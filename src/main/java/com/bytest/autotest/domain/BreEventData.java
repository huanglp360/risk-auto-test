package com.bytest.autotest.domain;

import java.io.Serializable;

/**
 * 新策略引擎事件表(BreEventData)实体类
 *
 * @author makejava
 * @since 2020-08-20 16:05:22
 */
public class BreEventData implements Serializable {
    private static final long serialVersionUID = 549680242151174761L;
    /**
     * 主键
     */
    private String requestId;
    /**
     * 业务系统自定义ID
     */
    private String businessId;
    /**
     * 事件调用系统标识代码
     */
    private String systemCode;
    /**
     * 决策点编号
     */
    private String decisionNum;
    /**
     * 登陆类型
     */
    private String loginType;
    /**
     * 渠道[自由、证大、去哪儿]
     */
    private String sourceType;
    /**
     * 产品类型
     */
    private String productType;
    /**
     * 客户渠道来源
     */
    private String custChannelCode;
    /**
     * 当前节点标识
     */
    private String nodeName;
    /**
     * 客户号
     */
    private String custNo;
    /**
     * 产品编码
     */
    private String prodNo;
    /**
     * 产品子类编码
     */
    private String subProdNo;
    /**
     * 类型，01授信差异化，02激活差异化，03交易差异化，04信息修改差异化
     */
    private String type;
    /**
     * 身份证
     */
    private String idNo;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 策略执行结果
     */
    private String dataPath;
    /**
     * 策略包标识
     */
    private String blazePackageName;
    /**
     * 实验编号
     */
    private String experimentNo;
    /**
     * 策略包标识
     */
    private String blazeSign;
    /**
     * 创建日期
     */
    private Integer createDate;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新日期
     */
    private Integer updateDate;
    /**
     * 更新时间
     */
    private String updateTime;


    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getDecisionNum() {
        return decisionNum;
    }

    public void setDecisionNum(String decisionNum) {
        this.decisionNum = decisionNum;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getCustChannelCode() {
        return custChannelCode;
    }

    public void setCustChannelCode(String custChannelCode) {
        this.custChannelCode = custChannelCode;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getProdNo() {
        return prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }

    public String getSubProdNo() {
        return subProdNo;
    }

    public void setSubProdNo(String subProdNo) {
        this.subProdNo = subProdNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDataPath() {
        return dataPath;
    }

    public void setDataPath(String dataPath) {
        this.dataPath = dataPath;
    }

    public String getBlazePackageName() {
        return blazePackageName;
    }

    public void setBlazePackageName(String blazePackageName) {
        this.blazePackageName = blazePackageName;
    }

    public String getExperimentNo() {
        return experimentNo;
    }

    public void setExperimentNo(String experimentNo) {
        this.experimentNo = experimentNo;
    }

    public String getBlazeSign() {
        return blazeSign;
    }

    public void setBlazeSign(String blazeSign) {
        this.blazeSign = blazeSign;
    }

    public Integer getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Integer createDate) {
        this.createDate = createDate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Integer updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

}