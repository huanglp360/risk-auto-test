package com.bytest.autotest.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (SceneCasesPool)实体类
 *
 * @author makejava
 * @since 2020-09-07 11:26:41
 */
@Data
public class SceneCasesPool implements Serializable {
    private static final long serialVersionUID = -20032023234163952L;
    /**
     * 主键
     */
    private String requestId;
    /**
     * 案例名称
     */
    private String caseName;
    /**
     * 案例描述
     */
    private String caseDesc;
    /**
     * 四要素姓名
     */
    private String elementName;
    /**
     * 西要素手机号
     */
    private String elementPhone;
    /**
     * 四要素银行卡
     */
    private String elementBank;
    /**
     * 四要素身份证
     */
    private String elementIdcard;
    /**
     * 客户绑卡手机号
     */
    private String elementBankMobile;
    /**
     * 前置json
     */
    private Object testData;
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