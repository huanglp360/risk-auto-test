package com.bytest.autotest.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 任务用例映射表(TaskCaseMapping)实体类
 *
 * @author makejava
 * @since 2020-09-09 15:56:11
 */
public class TaskCaseMapping implements Serializable {
    private static final long serialVersionUID = -89698871591114425L;
    /**
     * 主键
     */
    private String requestId;
    /**
     * 任务主键
     */
    private String taskId;
    /**
     * 用例主键
     */
    private String caseId;
    /**
     * 事件类型
     */
    private String eventType;
    /**
     * 产品小码
     */
    private String prodSubNo;
    /**
     * 1:场景，2：数据驱动
     */
    private String caseType;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;


    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getProdSubNo() {
        return prodSubNo;
    }

    public void setProdSubNo(String prodSubNo) {
        this.prodSubNo = prodSubNo;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}