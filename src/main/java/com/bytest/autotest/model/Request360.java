package com.bytest.autotest.model;

import lombok.Data;

import java.io.Serializable;

/**
 * <h3>tool</h3>
 * <p>360请求对象</p>
 *
 * @author : hh
 * @date : 2020-04-29 15:23
 **/
@Data
public class Request360 implements Serializable {
    //放款请求流水号
    private String loanReqNo;
    //请求方代码
    private String sourceCode;
    //客户名称
    private String custName;
    //证件类型
    private String idType;
    //证件号码
    private String id;
    //性别
    private String sex;
    //放款银行代码
    private String dbBankCode;
    //放款卡号
    private String dbAcct;
    //放款银行卡账户名
    private String dbAcctName;
    //放款申请时间
    private String loanDate;
    //放款金额
    private String loanAmt;
    //期数
    private String lnTerm;
    //授信额度
    private String creditAmt;
    //贷款用途
    private String loanPurpose;
    //解耦客户标识
    private String pbocFlag;
    //费率
    private String feeRate;
    //注册手机号
    private String mobileNo;
    //身份证有效期
    private String idValidDateEnd;
    //身份证地址
    private String idAddress;
    //身份证签发机关
    private String agency;
    //银行卡绑定手机号
    private String cardMobileNo;
    //是否客户名下任一张信用卡状态为呆帐、核销
    private String creditCardSts;
    //是否贷款账户状态为呆帐、核销
    private String loanAcctSts;
    //是否客户名下任一张信用卡在过去2年内有超过120天、150天、180天以上的逾期
    private String creditCardOverdueDays;
    //是否客户有过贷款在过去2年内有超过120天、150天、180天以上的逾期
    private String loanOverDays;
    //是否命中同盾、百融、前海、汇法黑名单
    private String thirdPartyBlackList;
    //核身风险等级
    private String idVerifyRisk;
    //是否有身份证或身份证明
    private String idCert;
    //满足年龄18至55岁
    private String ageCheck;
    //公安信息不存在
    private String policeInfoNotExist;
    //公安信息不匹配
    private String policeInfoNotMatch;
    //360平台上历史最大逾期天数
    private String overdueHisMaxDays;
    //360平台上历史最大逾期金额
    private String overdueHisMaxAmt;
    //A卡分
    private String ascore;
    //B卡分
    private String bscore;
    //360平台授信时间
    private String dateCredit;

}
