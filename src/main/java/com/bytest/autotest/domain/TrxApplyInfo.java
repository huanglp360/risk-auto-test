package com.bytest.autotest.domain;

import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 授信申请表(TrxApplyInfo)实体类
 *
 * @author makejava
 * @since 2020-08-27 10:11:22
 */
@ToString
public class TrxApplyInfo implements Serializable {
    private static final long serialVersionUID = -19163933077313197L;
    /**
     * 申请编号
     */
    private String applyNo;
    /**
     * 案件来源
     */
    private String applySource;
    /**
     * 产品限额码
     */
    private String prodNo;
    /**
     * 产品编码
     */
    private String prodSubNo;
    /**
     * 申请状态
     */
    private String applyStatus;
    /**
     * 联合贷款标志
     */
    private String syndicatedLoan;
    /**
     * 渠道编码
     */
    private String channalCode;
    /**
     * 申请结果
     */
    private String applyResult;
    /**
     * 申请结果描述
     */
    private String applyResultDesc;
    /**
     * 人工操作标志
     */
    private String artificialFlag;
    /**
     * 审批类型
     */
    private String approveType;
    /**
     * 审批结果
     */
    private String approveResult;
    /**
     * 授信结果码
     */
    private String awordResultCode;
    /**
     * 手机号
     */
    private String mobilePhoneNo;
    /**
     * 客户号
     */
    private String custNo;
    /**
     * 客户姓名
     */
    private String custName;
    /**
     * 客户性别
     */
    private String custSex;
    /**
     * 客户年龄
     */
    private String custAge;
    /**
     * 婚姻状态
     */
    private String maritalStatus;
    /**
     * 住房情况：01自购无按揭、02按揭、03租赁、04与父母同居、05公司宿舍/单位分配、06自建、07其他
     */
    private String houseSituation;
    /**
     * 银行卡类型
     */
    private String bankCardType;
    /**
     * 银行卡号
     */
    private String bankCardNo;
    /**
     * 证件类型
     */
    private String idType;
    /**
     * 证件号
     */
    private String idNo;
    /**
     * 首次办证省份代码
     */
    private String firstIdProvinceCode;
    /**
     * 首次办证省份
     */
    private String firstIdProvince;
    /**
     * 首次办证城市代码
     */
    private String firstIdCityCode;
    /**
     * 首次办证城市
     */
    private String firstIdCity;
    /**
     * 证件正面照URL
     */
    private String idFrontImgUrl;
    /**
     * 证件反而照URL
     */
    private String idBackImgUrl;
    /**
     * 活体检测正面照URL
     */
    private String livingImgurlOne;
    /**
     * 最高学历
     */
    private String degree;
    /**
     * 学校名称
     */
    private String schoolName;
    /**
     * 专业名称
     */
    private String majorName;
    /**
     * 备注
     */
    private String remark;
    /**
     * 防重标志
     */
    private String token;
    /**
     * 申请日期
     */
    private Double createDate;
    /**
     * 申请时间
     */
    private String createTime;
    /**
     * 修改日期
     */
    private Double updateDate;
    /**
     * 修改时间
     */
    private String updateTime;
    /**
     * 版本号
     */
    private Double version;
    /**
     * 人工处理日期
     */
    private Double artificialDate;
    /**
     * 人工处理时间
     */
    private String artificialTime;
    /**
     * 规则引擎授予结果
     */
    private String awordResult;
    /**
     * 风险定价
     */
    private String riskPricing;
    /**
     * 专案类型
     */
    private String caseType;
    /**
     * 随机数
     */
    private String applyRandomNo;
    /**
     * 流程实例ID
     */
    private String piid;
    /**
     * 入列日期
     */
    private Double queueDate;
    /**
     * 入列时间
     */
    private String queueTime;
    /**
     * 推广渠道
     */
    private String promotionChannel;
    /**
     * 核心流程ID
     */
    private String applyId;
    /**
     * 触发人工原因码
     */
    private String manualCauseCode;
    /**
     * 假脸判定
     */
    private String imageEnv;
    /**
     * 最终输出公司码
     */
    private String finalresultCompany;
    /**
     * 策略输出公司码
     */
    private String approveCompany;
    /**
     * 人工审批等级
     */
    private String manualApproveLevel;
    /**
     * 再次申请授信间隔天数
     */
    private Integer intervalDays;
    /**
     * 申请时间
     */
    private Date applyTime;
    /**
     * 推广进件渠道
     */
    private String accessChannel;


    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public String getApplySource() {
        return applySource;
    }

    public void setApplySource(String applySource) {
        this.applySource = applySource;
    }

    public String getProdNo() {
        return prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }

    public String getProdSubNo() {
        return prodSubNo;
    }

    public void setProdSubNo(String prodSubNo) {
        this.prodSubNo = prodSubNo;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getSyndicatedLoan() {
        return syndicatedLoan;
    }

    public void setSyndicatedLoan(String syndicatedLoan) {
        this.syndicatedLoan = syndicatedLoan;
    }

    public String getChannalCode() {
        return channalCode;
    }

    public void setChannalCode(String channalCode) {
        this.channalCode = channalCode;
    }

    public String getApplyResult() {
        return applyResult;
    }

    public void setApplyResult(String applyResult) {
        this.applyResult = applyResult;
    }

    public String getApplyResultDesc() {
        return applyResultDesc;
    }

    public void setApplyResultDesc(String applyResultDesc) {
        this.applyResultDesc = applyResultDesc;
    }

    public String getArtificialFlag() {
        return artificialFlag;
    }

    public void setArtificialFlag(String artificialFlag) {
        this.artificialFlag = artificialFlag;
    }

    public String getApproveType() {
        return approveType;
    }

    public void setApproveType(String approveType) {
        this.approveType = approveType;
    }

    public String getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult;
    }

    public String getAwordResultCode() {
        return awordResultCode;
    }

    public void setAwordResultCode(String awordResultCode) {
        this.awordResultCode = awordResultCode;
    }

    public String getMobilePhoneNo() {
        return mobilePhoneNo;
    }

    public void setMobilePhoneNo(String mobilePhoneNo) {
        this.mobilePhoneNo = mobilePhoneNo;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSex() {
        return custSex;
    }

    public void setCustSex(String custSex) {
        this.custSex = custSex;
    }

    public String getCustAge() {
        return custAge;
    }

    public void setCustAge(String custAge) {
        this.custAge = custAge;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getHouseSituation() {
        return houseSituation;
    }

    public void setHouseSituation(String houseSituation) {
        this.houseSituation = houseSituation;
    }

    public String getBankCardType() {
        return bankCardType;
    }

    public void setBankCardType(String bankCardType) {
        this.bankCardType = bankCardType;
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getFirstIdProvinceCode() {
        return firstIdProvinceCode;
    }

    public void setFirstIdProvinceCode(String firstIdProvinceCode) {
        this.firstIdProvinceCode = firstIdProvinceCode;
    }

    public String getFirstIdProvince() {
        return firstIdProvince;
    }

    public void setFirstIdProvince(String firstIdProvince) {
        this.firstIdProvince = firstIdProvince;
    }

    public String getFirstIdCityCode() {
        return firstIdCityCode;
    }

    public void setFirstIdCityCode(String firstIdCityCode) {
        this.firstIdCityCode = firstIdCityCode;
    }

    public String getFirstIdCity() {
        return firstIdCity;
    }

    public void setFirstIdCity(String firstIdCity) {
        this.firstIdCity = firstIdCity;
    }

    public String getIdFrontImgUrl() {
        return idFrontImgUrl;
    }

    public void setIdFrontImgUrl(String idFrontImgUrl) {
        this.idFrontImgUrl = idFrontImgUrl;
    }

    public String getIdBackImgUrl() {
        return idBackImgUrl;
    }

    public void setIdBackImgUrl(String idBackImgUrl) {
        this.idBackImgUrl = idBackImgUrl;
    }

    public String getLivingImgurlOne() {
        return livingImgurlOne;
    }

    public void setLivingImgurlOne(String livingImgurlOne) {
        this.livingImgurlOne = livingImgurlOne;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Double getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Double createDate) {
        this.createDate = createDate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Double getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Double updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Double getVersion() {
        return version;
    }

    public void setVersion(Double version) {
        this.version = version;
    }

    public Double getArtificialDate() {
        return artificialDate;
    }

    public void setArtificialDate(Double artificialDate) {
        this.artificialDate = artificialDate;
    }

    public String getArtificialTime() {
        return artificialTime;
    }

    public void setArtificialTime(String artificialTime) {
        this.artificialTime = artificialTime;
    }

    public String getAwordResult() {
        return awordResult;
    }

    public void setAwordResult(String awordResult) {
        this.awordResult = awordResult;
    }

    public String getRiskPricing() {
        return riskPricing;
    }

    public void setRiskPricing(String riskPricing) {
        this.riskPricing = riskPricing;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getApplyRandomNo() {
        return applyRandomNo;
    }

    public void setApplyRandomNo(String applyRandomNo) {
        this.applyRandomNo = applyRandomNo;
    }

    public String getPiid() {
        return piid;
    }

    public void setPiid(String piid) {
        this.piid = piid;
    }

    public Double getQueueDate() {
        return queueDate;
    }

    public void setQueueDate(Double queueDate) {
        this.queueDate = queueDate;
    }

    public String getQueueTime() {
        return queueTime;
    }

    public void setQueueTime(String queueTime) {
        this.queueTime = queueTime;
    }

    public String getPromotionChannel() {
        return promotionChannel;
    }

    public void setPromotionChannel(String promotionChannel) {
        this.promotionChannel = promotionChannel;
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public String getManualCauseCode() {
        return manualCauseCode;
    }

    public void setManualCauseCode(String manualCauseCode) {
        this.manualCauseCode = manualCauseCode;
    }

    public String getImageEnv() {
        return imageEnv;
    }

    public void setImageEnv(String imageEnv) {
        this.imageEnv = imageEnv;
    }

    public String getFinalresultCompany() {
        return finalresultCompany;
    }

    public void setFinalresultCompany(String finalresultCompany) {
        this.finalresultCompany = finalresultCompany;
    }

    public String getApproveCompany() {
        return approveCompany;
    }

    public void setApproveCompany(String approveCompany) {
        this.approveCompany = approveCompany;
    }

    public String getManualApproveLevel() {
        return manualApproveLevel;
    }

    public void setManualApproveLevel(String manualApproveLevel) {
        this.manualApproveLevel = manualApproveLevel;
    }

    public Integer getIntervalDays() {
        return intervalDays;
    }

    public void setIntervalDays(Integer intervalDays) {
        this.intervalDays = intervalDays;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getAccessChannel() {
        return accessChannel;
    }

    public void setAccessChannel(String accessChannel) {
        this.accessChannel = accessChannel;
    }

}