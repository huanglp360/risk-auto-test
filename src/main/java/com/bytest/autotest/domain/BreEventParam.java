package com.bytest.autotest.domain;

import java.io.Serializable;

/**
 * 策略引擎事件请求和响应参数表(BreEventParam01)实体类
 *
 * @author makejava
 * @since 2020-08-20 16:09:06
 */
public class BreEventParam implements Serializable {
    private static final long serialVersionUID = 132441122960635226L;
    /**
     * 主键
     */
    private String requestId;
    /**
     * 父id，主事件表REQUEST_ID
     */
    private String eventId;
    /**
     * 上级标识
     */
    private String parentNode;
    /**
     * 当前节点标识
     */
    private String nodeName;
    /**
     * 参数类型
     */
    private String paramType;
    /**
     * 参数名称
     */
    private String paramName;
    /**
     * 参数标识
     */
    private String paramCode;
    /**
     * 参数值
     */
    private String paramValue;
    /**
     * 参数值数据类型
     */
    private String paramValueType;
    /**
     * 参数描述
     */
    private String paramDesc;
    /**
     * 创建日期
     */
    private Integer createDate;
    /**
     * 创建时间
     */
    private Integer createTime;
    /**
     * 更新日期
     */
    private Integer updateDate;
    /**
     * 更新时间
     */
    private Integer updateTime;


    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getParentNode() {
        return parentNode;
    }

    public void setParentNode(String parentNode) {
        this.parentNode = parentNode;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamCode() {
        return paramCode;
    }

    public void setParamCode(String paramCode) {
        this.paramCode = paramCode;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getParamValueType() {
        return paramValueType;
    }

    public void setParamValueType(String paramValueType) {
        this.paramValueType = paramValueType;
    }

    public String getParamDesc() {
        return paramDesc;
    }

    public void setParamDesc(String paramDesc) {
        this.paramDesc = paramDesc;
    }

    public Integer getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Integer createDate) {
        this.createDate = createDate;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Integer updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

}