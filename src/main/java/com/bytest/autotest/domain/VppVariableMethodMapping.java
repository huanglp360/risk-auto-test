package com.bytest.autotest.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 策略点变量映射关系表(VppVariableMethodMapping)实体类
 *
 * @author makejava
 * @since 2020-08-18 14:43:01
 */
@Data
public class VppVariableMethodMapping implements Serializable {
    private static final long serialVersionUID = -40145133755164595L;
    /**
     * 主键
     */
    private String id;
    /**
     * 产品号
     */
    private String prod;
    /**
     * 策略点
     */
    private String stragetyPoint;
    /**
     * 策略点名称
     */
    private String stragetyPointName;
    /**
     * 变量名称
     */
    private String variableId;
    /**
     * 一个变量在一个流程中有可能查询多次查询，此字段控制是否重复查询并且覆盖之前的变量 0、重复查询并覆盖旧的 1、不重复查询不覆盖
     */
    private String repeat;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 修改人
     */
    private String updateBy;

    private String name;
    /**
     * 是否区分产品
     */
    private String distinguishProduct;




}