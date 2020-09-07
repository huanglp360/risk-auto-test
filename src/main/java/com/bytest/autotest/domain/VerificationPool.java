package com.bytest.autotest.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (VerificationPool)实体类
 *
 * @author makejava
 * @since 2020-09-07 11:30:11
 */
@Data
public class VerificationPool implements Serializable {
    private static final long serialVersionUID = 745761287489992041L;
    /**
     * 主键id
     */
    private String requestId;
    /**
     * 变量名
     */
    private String variableCode;
    /**
     * 变量id
     */
    private String variableId;
    /**
     * 变量值
     */
    private String variableValue;
    /**
     * 变量类型：string,integer,duble,...
     */
    private String variableDataType;
    /**
     * 变量默认值
     */
    private String defaultValue;
    /**
     * 渠道
     */
    private String channelInto;
    /**
     * 执行者映射id
     */
    private Integer procMapId;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;


}