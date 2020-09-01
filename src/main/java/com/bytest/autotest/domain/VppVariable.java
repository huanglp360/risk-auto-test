package com.bytest.autotest.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 变量池表(VppVariable)实体类
 *
 * @author makejava
 * @since 2020-08-17 11:31:31
 */
@Data
public class VppVariable implements Serializable {
    private static final long serialVersionUID = -93489784783421124L;
    /**
     * 主键
     */
    private String id;
    /**
     * 变量名称
     */
    private String variableName;
    /**
     * 变量描述
     */
    private String variableDesc;
    /**
     * 类名称
     */
    private String classname;
    /**
     * 方法名称
     */
    private String methodName;

    private String defaultValue;
    /**
     * 排序
     */
    private String sort;
    /**
     * 分组
     */
    private String group;
    /**
     * 0 有效 1失效
     */
    private String status;
    /**
     * 0 中断流程 1 不中断流程
     */
    private String interrupt;
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
    /**
     * 节点类型
     */
    private String targetObject;
    /**
     * 数据类型
     */
    private String fieldType;
    /**
     * 变量逻辑
     */
    private String variableLogic;


}