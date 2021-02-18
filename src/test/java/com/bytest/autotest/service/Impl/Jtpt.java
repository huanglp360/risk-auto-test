package com.bytest.autotest.service.Impl;

import com.bytest.autotest.domain.UserInfo;
import com.bytest.autotest.innerService.UserInfoService;
import com.bytest.autotest.model.jdjtpt.IdentityInfo;
import com.bytest.autotest.model.jdjtpt.JDPTreq;
import com.bytest.autotest.model.jdjtpt.JDuserInfo;
import com.bytest.autotest.model.jdjtpt.RequestData;
import com.bytest.autotest.util.http.HttpClient4;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.jmeter.JMeter;
import org.apache.jmeter.config.Argument;
import org.apache.jmeter.testelement.TestPlan;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * <h3>risk-auto-test</h3>
 * <p></p>
 *
 * @author : hh
 * @date : 2020-09-15 11:11
 **/
@Slf4j
@SpringBootTest
public class Jtpt {

    @Autowired
    UserInfoService userInfoService;


    //@Test
    void testCredit(){


        JDPTreq jdpTreq = new JDPTreq();
        jdpTreq.setRequestNo(String.valueOf(System.currentTimeMillis()));
        jdpTreq.setTxCode("CREDIT_APPLY");
        jdpTreq.setVersion("1.0");
        jdpTreq.setChannelCode("JD_JT");
        jdpTreq.setRequestTime(DateFormatUtils.format(new Date(),"yyyyMMddHHmmss"));

        RequestData req = new RequestData();
        req.setApplyNo(String.valueOf(System.currentTimeMillis()));
        req.setApplyTime(DateFormatUtils.format(new Date(),"yyyyMMddHHmmss"));
        req.setBusinessType("JT");

        UserInfo user_info = userInfoService.getUserNoused();
        JDuserInfo user = new JDuserInfo();
        user.setUsername(user_info.getName());
        user.setCertType("10100");
        user.setPin(user_info.getId_No());
        user.setCertNo(user_info.getId_No());
        user.setUserTel(user_info.getMobile());
        user.setAddress(user_info.getAddress());
        user.setInterestRate("0.0005");
        user.setApplyAmount("1000000");
        user.setActivateTag("UN_ACTIVATED");
        user.setCardNo(user_info.getBankcard());
        user.setBankNo(user_info.getMobile());
        user.setBkTel("user_info.getMobile()");
        user.setProfession("IT");
        user.setContactTel("15001065009");
        user.setContactName("小宝宝");
        user.setContactRelation("0308");
        user.setIdExpire("20260221");

        IdentityInfo ide = new IdentityInfo();
        ide.setFrontPhoto("");

    }

   // @Test
    void testdown(){
//        UserInfo user_info = userInfoService.getUserNoused();
//        String path =HttpClient4.downloadImage(user_info.getFrontpath());
//        log.info("获取到的路径地址：{}",path);

    }


    @Test
    void testjmeter(){
        JMeter jMeter = new JMeter();
        jMeter.start(new String[]{"12"});
        TestPlan testPlan = new TestPlan();
        Argument argument = new Argument();
        String key = argument.getName();
    }






}
