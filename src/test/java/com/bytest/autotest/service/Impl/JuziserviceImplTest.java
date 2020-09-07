package com.bytest.autotest.service.Impl;

import com.alibaba.fastjson.JSON;
import com.bytest.autotest.innerService.UserInfoService;
import com.bytest.autotest.innerService.VppVariableMethodMappingService;
import com.bytest.autotest.innerService.VppVariableService;
import com.bytest.autotest.service.Juziservice;
import com.bytest.autotest.util.http.HttpClient4;
import com.byxf.vpp.api.dto.ResponseRes;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
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

    @Value(value = "http://172.16.2.217:8142/b2b-front/channel/channel")
    String url;

    @Test
    void test() throws FileNotFoundException {
//        String result = "{\"returnMsg\":\"\",\"success\":true,\"resParams\":{\"custEnpName\":\"-9999\",\"custEnpCall\":\"-9999\",\"custEnpAddress\":\"-9999\"},\"reasonCode\":\"\",\"class\":\"com.byxf.vpp.api.dto.ResponseRes\"}";
//        JSON.parseObject(result,ResponseRes.class);
//
//        ResponseRes responseRes = JSON.parseObject(result,ResponseRes.class);
//        System.out.println(responseRes.getResParams());
//
//        Map<String,Object> map = responseRes.getResParams();
//        for (Map.Entry<String,Object> entry:map.entrySet()){
//            if(entry.getValue().equals("-9999")||entry.getValue().equals("1900-01-01")||entry.getValue().equals("1900-01-01T00:00:00.000")){
//
//            }
//        }

       String resultRES= HttpClient4.doPost("http://172.16.2.217:8142/b2b-front/channel/channel",JSON.toJSONString(juziservice.builecredit()));
        log.info(resultRES);
    }

    @Test
    void testdao(){
        System.out.println("autotestDateSource:"+userInfoService.getUserNoused());
        System.out.println("vppDateSource:"+variableService.queryById("0011809060000020001"));
        System.out.println("vppVariableMethondmapping:"+vppVariableMethodMappingService.queryAllByLimit(1,10));
    }

}