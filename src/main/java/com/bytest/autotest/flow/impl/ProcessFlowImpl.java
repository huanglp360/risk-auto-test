package com.bytest.autotest.flow.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytest.autotest.config.ServerConfig;
import com.bytest.autotest.domain.SceneCasesPool;
import com.bytest.autotest.domain.TaskCaseMapping;
import com.bytest.autotest.domain.TaskConfig;
import com.bytest.autotest.enums.RedisKey;
import com.bytest.autotest.flow.ProcessFlow;
import com.bytest.autotest.innerService.SceneCasesPoolService;
import com.bytest.autotest.innerService.TaskCaseMappingService;
import com.bytest.autotest.innerService.TaskConfigService;
import com.bytest.autotest.model.B2bRequest;
import com.bytest.autotest.model.CommPO;
import com.bytest.autotest.model.juzifenqi.ImgNameList;
import com.bytest.autotest.model.juzifenqi.LoanData;
import com.bytest.autotest.redis.RedisTool;
import com.bytest.autotest.util.KeyUtil;
import com.bytest.autotest.util.MD5;
import com.bytest.autotest.util.http.HttpClient4;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <h3>risk-auto-test</h3>
 * <p>业务执行类</p>
 *
 * @author : hh
 * @date : 2020-09-09 15:49
 **/
@Slf4j
@Service
public class ProcessFlowImpl implements ProcessFlow {
    @Autowired
    private TaskConfigService taskConfigService;

    @Autowired
    private TaskCaseMappingService taskCaseMappingService;

    @Autowired
    private SceneCasesPoolService sceneCasesPoolService;


    @Value("${b2curl}")
    private String url;

    @Value("${chanel_aes_key}")
    private String AES_KEY;

    @Value("${chanel_md5_key}")
    private String MD5_KEY;

    @Autowired
    RedisTool redisTool;

    @Autowired
    private ServerConfig serverConfig;

//    @Autowired
//    MongoTool mongoTool;

    @Override
    public void excuteCredit(String taskId) {

        TaskConfig taskConfig = taskConfigService.queryById(taskId);
        TaskCaseMapping taskCaseMapping = new TaskCaseMapping();
        taskCaseMapping.setRequestId(taskConfig.getRequestId());
        List<TaskCaseMapping> task_case_map = taskCaseMappingService.queryAll(taskCaseMapping);

        Map<String,String> apply_map = new HashMap<String, String>();

        for (TaskCaseMapping tcm : task_case_map) {

            log.info("开始执行自动化测试任务，用例编号{}", tcm.getCaseId());

            if(tcm.getEventType().equals("creditAward")){

                SceneCasesPool sceneCasesPool = sceneCasesPoolService.queryById(tcm.getCaseId());
                log.info("开始执行测试用例:{},用例名称：{}，四要素数据:姓名:{},身份证号码{},手机号:{},银行卡号:{}", sceneCasesPool.getRequestId(), sceneCasesPool.getCaseName(), sceneCasesPool.getElementName(), sceneCasesPool.getElementIdcard(), sceneCasesPool.getElementPhone(), sceneCasesPool.getElementBank());
                //TODO 上线后需要修改url获取方式：serverConfig.getLocalUrl()+url,且配置文件需要切换短地址
                JSONObject parseObject = JSON.parseObject(sceneCasesPool.getTestData());
                //组装渠道数据报文
                String request_data = parseObject.getString("data");
                CommPO commPO = parseObject.getObject("comm", CommPO.class);

                commPO.setSigntx(MD5.digest(request_data + "|" + MD5_KEY));
                commPO.setOrdrno(String.valueOf(System.currentTimeMillis()));

                B2bRequest b2bRequest = new B2bRequest();
                b2bRequest.setComm(commPO);
                try {
                    b2bRequest.setData(KeyUtil.encryptAES(request_data, AES_KEY));
                }catch (Exception e){
                    log.error("请求报文加密异常{}",e);
                    //TODO 记录测试用例异常状态
                }
                String param = JSONObject.toJSONString(b2bRequest);
                //组装完成
                String result = HttpClient4.doPost(url, param);
                JSONObject jsonObject = JSON.parseObject(result);
                String data = JSON.toJSONString(jsonObject.get("data"));
                //解密返回报文
                try {
                    String reqDencryptJSON = KeyUtil.decryptAES(data, AES_KEY);
                    JSONObject re = JSON.parseObject(reqDencryptJSON);
                    if ("0500".equals(re.getString("respcd"))){
                        String apply_no = re.get("busNumber").toString();
                        log.info("测试用例{}请求完成，案件号为：{}", tcm.getCaseId(), apply_no);
                        //TODO 授信业务案件号需要存储到某个地方:redis？？
                        apply_map.put(apply_no, tcm.getCaseId());
                    }

                }catch (Exception e){
                    e.printStackTrace();

                }
            }
        }
        //MAP《案件号，用例号》放入缓存
        redisTool.hmset(RedisKey.APPLY_KEY.getCode(), apply_map);
        redisTool.setExpire(RedisKey.APPLY_KEY.getCode(), RedisTool.ONEHOUR);
        taskConfig.setTaskStatus("2");


    }

    private void excuteCase(String caseId){
        String param = getCreditReqData(caseId);

        String result = HttpClient4.doPost(url,param);

    }

    private String getCreditReqData(String caseId){
        SceneCasesPool sceneCasesPool = sceneCasesPoolService.queryById(caseId);
        String testdata = sceneCasesPool.getTestData();
        JSONObject js = JSON.parseObject(testdata);
        CommPO commPO = js.getJSONObject("comm").toJavaObject(CommPO.class);
        commPO.setOrdrno(String.valueOf(System.currentTimeMillis()));
        commPO.setSigntx(MD5.digest(js.getString("data") + "|" + MD5_KEY));
        B2bRequest b2bRequest = new B2bRequest();
        b2bRequest.setComm(commPO);
        b2bRequest.setData(KeyUtil.encryptAES(js.getString("data"),AES_KEY));

        return JSONObject.toJSONString(b2bRequest);
    }

    @Override
    public void excuteLoan(Map<String,String> map) {
        try{
            List<String> params = buildLoanRequest(map);
            for (String data:params) {
                HttpClient4.doPost(url,data);
            }

        }catch (Exception e){
            log.error("执行借款事件异常{}",e.getMessage());
        }


    }


    //TODO 组装借款事件报文
    private List<String> buildLoanRequest(Map<String,String> map) throws Exception {

        List<String> datas = new ArrayList<String>();
        for (Map.Entry<String,String> entry : map.entrySet()) {
            B2bRequest b2bRequest = new B2bRequest();
            SceneCasesPool sceneCasesPool = sceneCasesPoolService.queryById(entry.getValue());

            //公共报文comm部分
            String request = sceneCasesPool.getTestData();
            JSONObject req_json = JSONObject.parseObject(request);
            JSONObject com_json = req_json.getJSONObject("comm");
            CommPO commPO = com_json.toJavaObject(CommPO.class);
            commPO.setTxncd("loanPayments");
            commPO.setOrdrno(String.valueOf(System.currentTimeMillis()));
            commPO.setInvktm(DateFormatUtils.format(new Date(),"yyyyMMdd HH:mm:ss"));

            //TODO 某些字段写死，例如身份证号码类型，回传地址，
            //组装数据报文data部分
            JSONObject data_json = req_json.getJSONObject("data");
            LoanData loanData = new LoanData();
            loanData.setBankCardNo(sceneCasesPool.getElementBank());
            loanData.setBusNumber(entry.getKey());
            loanData.setCallbackUrl("http://172.16.2.217:9090/callback");
            loanData.setCustName(sceneCasesPool.getElementName());
            loanData.setIdNo(sceneCasesPool.getElementIdcard());
            loanData.setIdType("01");
            loanData.setProdSubNo(sceneCasesPool.getProdSubNo());
            loanData.setImgNameList(data_json.getJSONArray("imgNameList").toJavaList(ImgNameList.class));

            //融资担保公司
            //if(data_json.getString("")){}


            //数据加密
            String loanData_str = JSON.toJSONString(loanData);
            commPO.setSigntx(MD5.digest(loanData_str + "|" + MD5_KEY));

            b2bRequest.setComm(commPO);
            b2bRequest.setData(KeyUtil.encryptAES(loanData_str, AES_KEY));

            datas.add(JSON.toJSONString(b2bRequest));

        }

        return datas;
    }
}
