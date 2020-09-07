package com.bytest.autotest.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (ProcessingMapping)实体类
 *
 * @author makejava
 * @since 2020-09-07 11:24:44
 */
@Data
public class ProcessingMapping implements Serializable {
    private static final long serialVersionUID = 673435466077634987L;
    /**
     * 主键
     */
    private String requestId;
    /**
     * 场景驱动id,数据驱动id
     */
    private String processId;
    /**
     * 1:场景ie，2：数据驱动
     */
    private String scanOrData;
    /**
     * 变量名
     */
    private String variableCode;
    /**
     * 变量id
     */
    private String variableId;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdate;
    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date update;



}