package com.bytest.autotest.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytest.autotest.innerService.UserInfoService;
import com.bytest.autotest.innerService.VppVariableMethodMappingService;
import com.bytest.autotest.innerService.VppVariableService;
import com.bytest.autotest.model.B2bRequest;
import com.bytest.autotest.model.RequestData;
import com.bytest.autotest.service.Juziservice;
import com.bytest.autotest.util.KeyUtil;
import com.bytest.autotest.util.http.HttpClient4;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

/**
 * <h3>risk-auto-test</h3>
 * <p></p>
 *
 * @author : hh
 * @date : 2020-05-21 11:20
 **/
@Slf4j
@SpringBootTest
class JuziserviceImplTest {

    @Autowired
    VppVariableService variableService;

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    VppVariableMethodMappingService vppVariableMethodMappingService;

    @Autowired
    Juziservice juziservice;

    @Value("${b2curl}")
    String url;

    @Value("${chanel_aes_key}")
    String AES;

   // @Test
    void test() throws Exception {

        log.info("请求的地址为：{}",url);
       // String req = JSON.toJSONString(juziservice.builecredit());

        RequestData requestData = juziservice.builecredit();
        log.info("请求的字符串为：{}",requestData);
        //requestData.getData();
        B2bRequest b2bRequest = new B2bRequest();
        b2bRequest.setComm(requestData.getComm());
        b2bRequest.setData(KeyUtil.encryptAES(JSON.toJSONString(requestData.getData()),AES));
        log.info("最终的请求的字符串为：》》{}",b2bRequest);


       String resultRES= HttpClient4.doPost(url,JSON.toJSONString(b2bRequest));
        JSONObject JS = JSON.parseObject(resultRES);
        String data = JS.get("data").toString();
        String result = KeyUtil.decryptAES(data, AES);
        log.info("返回结果为：》》{}，返回的data内容为：{}",resultRES,result);
    }

   // @Test
    void testdao(){
        System.out.println("autotestDateSource:"+userInfoService.getUserNoused());
        System.out.println("vppDateSource:"+variableService.queryById("0011809060000020001"));
        System.out.println("vppVariableMethondmapping:"+vppVariableMethodMappingService.queryAllByLimit(1,10));
    }

}