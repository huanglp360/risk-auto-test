package com.bytest.autotest.model.juzifenqi;

import lombok.Data;

import java.util.List;

/**
 * <h3>tool</h3>
 * <p>传递基础数据</p>
 *
 * @author : hh
 * @date : 2020-03-19 23:13
 **/
@Data
public class DataPO {
    private String prodSubNo;
    private String mercNo;
    private String mercName;
    private String custName;
    private String idType;
    private String idNo;
    private String mobNo;
    private String fixRepayDay;
    private String callbackUrl;
    private String marrStatus;
    private String eduDegree;
    private String queryCreditFlag;
    private String applyDate;
    private String applyTime;
    private LoanInfo loanInfo;
    private List<UserRelationInfo> userRelationInfos;
    private List<CompanyInfo> companyInfo;
    private SpouseInfo spouseInfo;
    private AgentCustBankcardAuthInfo agentCustBankcardAuthInfo;
    private List<ImgNameList> imgNameList;
    private List<PhoneDirectorys> phoneDirectorys;
    private List<ChanlRiskinfo> chanlRiskinfo;
}
