package com.bytest.autotest.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bytest.autotest.aspect.DynamicSource;
import com.bytest.autotest.domain.UserInfo;
import com.bytest.autotest.enums.DateSourceType;
import com.bytest.autotest.innerService.UserInfoService;
import com.bytest.autotest.model.CommPO;
import com.bytest.autotest.model.RequestData;
import com.bytest.autotest.model.juzifenqi.*;
import com.bytest.autotest.service.Juziservice;
import com.bytest.autotest.util.DataUtils;
import com.bytest.autotest.util.KeyUtil;
import com.bytest.autotest.util.MD5;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <h3>risk-auto-test</h3>
 * <p>橘子分期</p>
 *
 * @author : hh
 * @date : 2020-05-19 11:28
 **/
@Slf4j
@Service
public class JuziserviceImpl implements Juziservice {

    @Autowired
    UserInfoService userInfoService;

    @Value("${chanel_md5_key}")
    private String md5_key;

    @Value("${chanel_aes_key}")
    private String aes_key;

    @Override
    public RequestData builecredit(){
        UserInfo userInfo = userInfoService.getUserNoused();
        RequestData requestData = new RequestData();
        //公共报文部分
        CommPO commPO = new CommPO();
        commPO.setChanlno("0101030023");
        commPO.setEncrmd("01");
        commPO.setInvktm(String.valueOf(System.currentTimeMillis()));
        commPO.setVersion("V2_1");
        commPO.setSigntp("001");
        commPO.setChanltp("C-00");
        commPO.setTxncd("loanExamines");
        commPO.setEncodg("utf-8");
        commPO.setNeedret("yes");
        commPO.setOrdrno(String.valueOf(System.currentTimeMillis()));

        //data部分
        DataPO dataPO = new DataPO();
        dataPO.setProdSubNo("510001");
        dataPO.setMercName("fql_002");
        dataPO.setMercNo("12345678901234567890123456789012");
        dataPO.setCustName(userInfo.getName());
        dataPO.setIdType("01");
        dataPO.setIdNo(userInfo.getId_No());
        dataPO.setMobNo(userInfo.getMobile());
        dataPO.setFixRepayDay("22");
        dataPO.setCallbackUrl("http://223.223.203.240:8142/b2b-front/notify/notice");
        dataPO.setMarrStatus("20");
        dataPO.setEduDegree("本科");
        dataPO.setQueryCreditFlag("Y");
        Date date = new Date();
        dataPO.setApplyDate(DateFormatUtils.format(date,"yyyyMMdd"));
        dataPO.setApplyTime(DateFormatUtils.format(date,"HHmmss"));


        //借款信息
        LoanInfo loanInfo = new LoanInfo();
        loanInfo.setRepayInterval("01");
        loanInfo.setFirstPayDate("");
        loanInfo.setTransAmt("1000.00");
        loanInfo.setTotalCnt("3");
        loanInfo.setRepayMethod("03");
        loanInfo.setLoanUse("01");

        dataPO.setLoanInfo(loanInfo);

        //联系人信息
        UserRelationInfo userRelationInfo = new UserRelationInfo();
        userRelationInfo.setContactsRelations("1");
        userRelationInfo.setContactsName("大橘子");
        userRelationInfo.setContactsMobile("13581857139");
        userRelationInfo.setContactsRelations2("3");
        userRelationInfo.setContactsName2("小橘子");
        userRelationInfo.setContactsMobile2("13581857140");

        List<UserRelationInfo> relationinfo_list = new ArrayList();
        relationinfo_list.add(userRelationInfo);

        dataPO.setUserRelationInfos(relationinfo_list);

        //公司信息
        CompanyInfo companyInfo1 = new CompanyInfo();
        companyInfo1.setRelation("01");
        companyInfo1.setComyName("包银消费");
        companyInfo1.setMonthIncome("10000.00");
        companyInfo1.setComyNature("05");
        companyInfo1.setComyAdd("北京市朝阳区");
        companyInfo1.setBusinessNature("A");

        CompanyInfo companyInfo2 = new CompanyInfo();
        companyInfo2.setRelation("02");
        companyInfo2.setComyName("不知道");
        companyInfo2.setMonthIncome("10000.00");
        companyInfo2.setComyNature("05");
        companyInfo2.setComyAdd("北京市通州区大运河");
        companyInfo2.setBusinessNature("A");

        List<CompanyInfo> companyInfo_list = new ArrayList();
        companyInfo_list.add(companyInfo1);
        companyInfo_list.add(companyInfo2);

        dataPO.setCompanyInfo(companyInfo_list);
        //配偶信息
        SpouseInfo spouseInfo = new SpouseInfo();
        spouseInfo.setSpouseName("未知");
        spouseInfo.setMobNo("18501187655");

        dataPO.setSpouseInfo(spouseInfo);

        //银行卡信息
        AgentCustBankcardAuthInfo agentCustBankcardAuthInfo = new AgentCustBankcardAuthInfo();
        agentCustBankcardAuthInfo.setBankCardNo(userInfo.getBankcard());
        agentCustBankcardAuthInfo.setBankCardType("1");
        agentCustBankcardAuthInfo.setCustName(userInfo.getName());
        agentCustBankcardAuthInfo.setIdType("01");
        agentCustBankcardAuthInfo.setIdNo(userInfo.getId_No());
        agentCustBankcardAuthInfo.setMobileNo(userInfo.getMobile());

        dataPO.setAgentCustBankcardAuthInfo(agentCustBankcardAuthInfo);

        //影音资料信息
        //身份证正面
        ImgNameList imgNameList = new ImgNameList();
        imgNameList.setImageType("01");
        imgNameList.setImageUrl(userInfo.getFrontpath());
        imgNameList.setTransportProtocol("01");

        //身份证反面
        ImgNameList imgNameList1 = new ImgNameList();
        imgNameList1.setImageType("02");
        imgNameList1.setImageUrl(userInfo.getBackpath());
        imgNameList1.setTransportProtocol("01");

        //活体
        ImgNameList imgNameList2 = new ImgNameList();
        imgNameList2.setImageType("03");
        imgNameList2.setImageUrl(userInfo.getHuotipath());
        imgNameList2.setTransportProtocol("01");

        //没搞清楚是什么图片
        ImgNameList imgNameList3 = new ImgNameList();
        imgNameList3.setImageUrl("http://172.16.2.209/bsmedia/test.pdf");
        imgNameList3.setImageType("06");
        imgNameList3.setTransportProtocol("01");

        ImgNameList imgNameList4 = new ImgNameList();
        imgNameList4.setImageUrl("http://172.16.2.209/bsmedia/test.pdf");
        imgNameList4.setImageType("08");
        imgNameList4.setTransportProtocol("01");

        List<ImgNameList> imgNameLists = new ArrayList<>();
        imgNameLists.add(imgNameList);
        imgNameLists.add(imgNameList1);
        imgNameLists.add(imgNameList2);
        imgNameLists.add(imgNameList3);
        imgNameLists.add(imgNameList4);

        dataPO.setImgNameList(imgNameLists);

        //添加不知道是什么的电话信息
        PhoneDirectorys phoneDirectorys = new PhoneDirectorys();
        phoneDirectorys.setMobNo(userInfo.getMobile());
        phoneDirectorys.setName("不知道");
        List<PhoneDirectorys> phoneDirectorysList = new ArrayList<>();
        phoneDirectorysList.add(phoneDirectorys);

        dataPO.setPhoneDirectorys(phoneDirectorysList);

        //添加风控信息

        String str = "";
        try {
            File tree = ResourceUtils.getFile("/home/auto-test/juzifenqi_riskinfo_json.json");
            if (!tree.exists()){
                str= DataUtils.txt2String(System.getProperty("user.dir") + "/data/juzifenqi_riskinfo_json.json");
            }else {
                str=DataUtils.txt2String(tree.getAbsolutePath());
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }


        List<ChanlRiskinfo> risk_list = JSONArray.parseArray(str,ChanlRiskinfo.class);

        dataPO.setChanlRiskinfo(risk_list);

        //数据加密
        commPO.setSigntx(MD5.digest(JSONObject.toJSONString(dataPO)+"|"+md5_key));
        requestData.setComm(commPO);
//        try {
//
//            requestData.setData(KeyUtil.encryptAES(JSONObject.toJSONString(dataPO),aes_key));
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        requestData.setComm(commPO);
        requestData.setData(dataPO);




        return requestData;
    }

    public RequestData builecredit(RequestData is){
        is.getComm().setSigntx(MD5.digest(JSONObject.toJSONString(is.getData())+"|"+md5_key));

        return null;
    }
}
