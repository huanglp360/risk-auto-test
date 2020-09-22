package com.bytest.autotest.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 测试任务表(TaskConfig)实体类
 *
 * @author makejava
 * @since 2020-09-09 15:52:04
 */
public class TaskConfig implements Serializable {
    private static final long serialVersionUID = 568618868830055310L;
    /**
     * 主键
     */
    private String requestId;
    /**
     * 任务名称
     */
    private String taskName;
    /**
     * 任务描述
     */
    private String taskDesc;
    /**
     * 任务状态：1：未开启，2：执行中：3：执行完成
     */
    private String taskStatus;
    /**
     * 任务创建者
     */
    private String createUeser;
    /**
     * 创建时间
     */
    private Date createdatetime;
    /**
     * 更新时间
     */
    private Date updatetime;


    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getCreateUeser() {
        return createUeser;
    }

    public void setCreateUeser(String createUeser) {
        this.createUeser = createUeser;
    }

    public Date getCreatedatetime() {
        return createdatetime;
    }

    public void setCreatedatetime(Date createdatetime) {
        this.createdatetime = createdatetime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

}