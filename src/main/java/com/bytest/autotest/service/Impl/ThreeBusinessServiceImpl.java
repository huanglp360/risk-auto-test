package com.bytest.autotest.service.Impl;

import com.bytest.autotest.dao.UserInfoDao;
import com.bytest.autotest.domain.UserInfo;
import com.bytest.autotest.innerService.UserInfoService;
import com.bytest.autotest.model.Request360;
import com.bytest.autotest.service.ThreeBusinessService;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <h3>risk-auto-test</h3>
 * <p>360业务</p>
 *
 * @author : hh
 * @date : 2020-05-04 01:27
 **/
@Service
public class ThreeBusinessServiceImpl implements ThreeBusinessService {
    @Autowired
    UserInfoService userInfoService;

    @Autowired
    UserInfoDao userInfoDao;

    @Override
    public Request360 bulidRquest(){
        UserInfo userInfo = userInfoService.getUserNoused();
        Request360 request360 = new Request360();

        request360.setLoanReqNo(String.valueOf(System.currentTimeMillis()));
        request360.setSourceCode("QH");
        request360.setCustName(userInfo.getName());
        request360.setIdType("1");
        request360.setId(userInfo.getId_No());
        if(userInfo.getSex().equals("男")){
            request360.setSex("M");
        }else {
            request360.setSex("F");
        }

//        0001	中国银行
//        0002	农业银行
//        0003	工商银行
//        0004	建设银行
//        0005	交通银行
//        0006	光大银行
//        0007	民生银行
//        0008	平安银行
//        0009	邮储银行
//        0010	广发银行
//        0011	中信银行
//        0012	华夏银行
//        0013	浦发银行
//        0014	兴业银行
//        0015	招商银行
//        0017	杭州银行
//        0018	上海银行
//        0019	北京银行

        request360.setDbBankCode("0004");//0004建设银行
        request360.setDbAcct(userInfo.getBankcard());
        request360.setDbAcctName(userInfo.getName());
        // DateFormatUtils.format(new Date(),"YYYY-MM-DD HH24:MI:SS");
        request360.setLoanDate(DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
        request360.setLoanAmt("1000");
        request360.setLnTerm("3");
        request360.setCreditAmt("2000");
        //“08 装修房屋”、“ 10支付教育支出”、“ 11支付医疗支出”、“ 12支付旅游支出
        request360.setLoanPurpose("08");
        request360.setPbocFlag("Y");
        request360.setFeeRate("0.01");
        request360.setMobileNo(userInfo.getMobile());
        request360.setIdValidDateEnd("9999-12-31");
        request360.setIdAddress(userInfo.getAddress());
        request360.setAgency("北京市公安局");
        request360.setCardMobileNo(userInfo.getMobile());
        request360.setCreditCardSts("N");
        request360.setLoanAcctSts("N");
        request360.setCreditCardOverdueDays("N");
        request360.setLoanOverDays("N");
        request360.setThirdPartyBlackList("N");
        request360.setIdVerifyRisk("A");
        request360.setIdCert("Y");
        request360.setAgeCheck("Y");
        request360.setPoliceInfoNotExist("Y");
        request360.setPoliceInfoNotMatch("Y");
        request360.setOverdueHisMaxDays("0");
        request360.setOverdueHisMaxAmt("0");
        request360.setAscore("100");
        request360.setBscore("100");
        request360.setDateCredit("2020-04-20");
        userInfo.setIsused("1");
        userInfoDao.updateByPrimaryKey(userInfo);

        return request360;

    }

    private Request360 build(UserInfo userInfo){


        Request360 request360 = new Request360();
        request360.setLoanReqNo(String.valueOf(System.currentTimeMillis()));
        request360.setSourceCode("QH");
        request360.setCustName(userInfo.getName());
        request360.setIdType("1");
        request360.setId(userInfo.getId_No());
        if(userInfo.getSex().equals("男")){
            request360.setSex("M");
        }else {
            request360.setSex("F");
        }

//        0001	中国银行
//        0002	农业银行
//        0003	工商银行
//        0004	建设银行
//        0005	交通银行
//        0006	光大银行
//        0007	民生银行
//        0008	平安银行
//        0009	邮储银行
//        0010	广发银行
//        0011	中信银行
//        0012	华夏银行
//        0013	浦发银行
//        0014	兴业银行
//        0015	招商银行
//        0017	杭州银行
//        0018	上海银行
//        0019	北京银行

        request360.setDbBankCode("0004");//0004建设银行
        request360.setDbAcct(userInfo.getBankcard());
        request360.setDbAcctName(userInfo.getName());
        // DateFormatUtils.format(new Date(),"YYYY-MM-DD HH24:MI:SS");
        request360.setLoanDate(DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
        request360.setLoanAmt("1000");
        request360.setLnTerm("3");
        request360.setCreditAmt("5000");
        //“08 装修房屋”、“ 10支付教育支出”、“ 11支付医疗支出”、“ 12支付旅游支出
        request360.setLoanPurpose("08");
        request360.setPbocFlag("Y");
        request360.setFeeRate("0.01");
        request360.setMobileNo(userInfo.getMobile());
        request360.setIdValidDateEnd("9999-12-31");
        request360.setIdAddress(userInfo.getAddress());
        request360.setAgency("北京市公安局");
        request360.setCardMobileNo(userInfo.getMobile());
        request360.setCreditCardSts("N");
        request360.setLoanAcctSts("N");
        request360.setCreditCardOverdueDays("N");
        request360.setLoanOverDays("N");
        request360.setThirdPartyBlackList("N");
        request360.setIdVerifyRisk("A");
        request360.setIdCert("Y");
        request360.setAgeCheck("Y");
        request360.setPoliceInfoNotExist("Y");
        request360.setPoliceInfoNotMatch("Y");
        request360.setOverdueHisMaxDays("0");
        request360.setOverdueHisMaxAmt("0");
        request360.setAscore("100");
        request360.setBscore("100");
        request360.setDateCredit("2020-04-20");
        userInfo.setIsused("1");
        userInfoDao.updateByPrimaryKey(userInfo);
        return request360;
    }

}
