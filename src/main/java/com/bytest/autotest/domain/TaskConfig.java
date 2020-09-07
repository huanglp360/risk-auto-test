package com.bytest.autotest.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (TaskConfig)实体类
 *
 * @author makejava
 * @since 2020-09-07 11:29:53
 */
@Data
public class TaskConfig implements Serializable {
    private static final long serialVersionUID = 905246299940052148L;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdatetime;
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatetime;



}