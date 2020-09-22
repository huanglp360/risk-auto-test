package com.bytest.autotest.innerService.impl;

import com.bytest.autotest.innerService.BreEventDataService;
import com.bytest.autotest.innerService.BreEventParamService;
import com.bytest.autotest.innerService.VppVariableMethodMappingService;
import com.bytest.autotest.innerService.VppVariableService;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * <h3>risk-auto-test</h3>
 * <p></p>
 *
 * @author : hh
 * @date : 2020-05-02 15:30
 **/
@SpringBootTest
class EasyuiNavServiceImplTest {

    @Autowired
    BreEventParamService breEventParamService;

    @Autowired
    BreEventDataService breEventDataService;

//    @Autowired
//    SuperTestInterface superTestInterface;

    @Autowired
    VppVariableService vppVariableService;

    @Autowired
    VppVariableMethodMappingService vppVariableMethodMappingService;
  //  @Test
    void getNavList() {
       // easyuiNavService.getNavList();
    }

   // @Test
    void testlog(){
        try {
            throw new RuntimeException("客户证件信息不存在");
        }catch (Exception e){
            String message = e.getMessage();
            if (message != null && message.contains("客户证件信息不存在")) {
                //log.warn("获取客户号异常=" + e.getMessage(), e);
            }

           //log.error("查询策略点:" + "变量异常:" + throwable.getMessage(), throwable);
        }
    }

   // @Test
    void testlog2(){
        try {
            throw new RuntimeException("客户证件信息不存在");
           // throw new
        }catch (Throwable throwable){
            //log.error("查询策略点:" + "变量异常:" , throwable.fillInStackTrace());
            //log.error("查询策略点:" + "变量异常:" + throwable.getMessage(), throwable);
        }
    }




  //  @Test
    void testparams() throws IOException {
//        List<BreEventData> list_data =breEventDataService.queryByBusinessId("C592008252960340013");
//        List<BreEventParam> list_one = breEventParamService.queryByIdAndDay(list_data.get(0).getRequestId(),"25");
//        List<BreEventParam> list_two = breEventParamService.queryByIdAndDay(list_data.get(1).getRequestId(),"25");
//        Map<String,Object> map = new HashMap<String,Object>();
//        for (BreEventParam para:list_one) {
//            map.put(para.getParamCode(),para.getParamValue());
//            if(para.getParamValue().equals("-9999")||para.getParamValue().equals("-9997")||para.getParamValue().equals("-9996")||para.getParamValue().equals("1900-01-01")){
//                System.out.println("决策点："+list_data.get(0).getDecisionNum()+"有问题的变量为："+para.getParamCode()+">值==>"+para.getParamValue());
//            }
//        }
//       // System.out.println("map的大小为："+list_one.size());
//        Data2xlsx.writeMaps("D:/testSina"+list_data.get(0).getDecisionNum(),map);
//        //Runtime.getRuntime().exec("cmd /c D://testSina.xlsx");
//        map.clear();
//        for (BreEventParam para:list_two){
//            map.put(para.getParamCode(),para.getParamValue());
//            if(para.getParamValue().equals("-9999")||para.getParamValue().equals("-9997")||para.getParamValue().equals("-9996")||para.getParamValue().equals("1900-01-01")){
//                System.out.println("决策点："+list_data.get(1).getDecisionNum()+"有问题的变量为："+para.getParamCode()+">值==>"+para.getParamValue());
//            }
//        }
//        Data2xlsx.writeMaps("D:/testSina"+list_data.get(1).getDecisionNum(),map);
//        Runtime.getRuntime().exec("cmd /c "+"D:/testSina"+list_data.get(0).getDecisionNum()+".xlsx");
//        Runtime.getRuntime().exec("cmd /c "+"D:/testSina"+list_data.get(1).getDecisionNum()+".xlsx");
    }

  //  @Test
    void testDate(){
//      //  String day = DateFormatUtils.format(new Date(),"dd");
//       // List<BreEventParam> list = breEventParamService.queryByIdAndDay("C012008200019810135",day);
//       // Data2xlsx.write("D:/test11",list);
//        List<VppVariableMethodMapping> vpmm = vppVariableMethodMappingService.queryBystragetyPoint("503:0101030016:D01");
//
//        //List<VppVariable> listVariables = vppVariableService.queryAllByLimit(1,10);
////
////        RequestArgs requestArgs = new RequestArgs();
////        requestArgs.setCustNo("150000010026");
////        requestArgs.setApplyNo("C592008202960330008");
////        requestArgs.setIdNo("430105198005277169");
////        requestArgs.setCustName("钭谷丝");
////        requestArgs.setBankCardNo("6217000010133873471");
////        requestArgs.setBankCardType("1");
////        requestArgs.setBankMobileNo("15033873471");
////        requestArgs.setChannelInto("0101030016");
////        requestArgs.setCustAge("40");
////        requestArgs.setCustSex("F");
////        requestArgs.setEventType("creditAward");
////        requestArgs.setIdBackImgUrl("http://172.16.2.217/bsmedia/0101030016/202008/20200821/401bb425896e46baa020b7d1c2a684d2.png");
////        requestArgs.setIdFrontImgUrl("http://172.16.2.217/bsmedia/0101030016/202008/20200821/bf7ccb64ee0c4fb9a573d0b1cc80a6d1.bmp");
////        requestArgs.setIdIssueOrigName("长沙市公安局芙蓉分局");
////        requestArgs.setIdIssueTime(20160216);
////        requestArgs.setIdType("01");
////        requestArgs.setMobilePhoneNo("15033873471");
////        requestArgs.setProcessInstanceId("2b6d25fb-e37a-11ea-8d3b-005056bd17af");
////        requestArgs.setProdNo("503");
////        requestArgs.setProdSubNo("503001");
////        requestArgs.setSystemCode("crs");
////        requestArgs.setTransAmt(new BigDecimal(500.00));
//
//
//        Map<String,Object> response = new HashMap<String, Object>();
//        for (VppVariableMethodMapping var:vpmm) {
////
////            ResponseRes responseRes = superTestInterface.singleExcute(requestArgs,var.getVariableId());
////            response.putAll(responseRes.getResParams());
//
//        }
//        Data2xlsx.writeMaps("D:/testSinaSingleVar",response);
//        System.out.println(response);
//

    }
}