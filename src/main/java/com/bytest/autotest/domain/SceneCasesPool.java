package com.bytest.autotest.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 场景测试用例表(SceneCasesPool)实体类
 *
 * @author makejava
 * @since 2020-09-09 16:13:13
 */
@Data
public class SceneCasesPool implements Serializable {
    private static final long serialVersionUID = -42782376231035142L;
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
     * 产品小码
     */
    private String prodSubNo;
    /**
     * 产品号
     */
    private String prodNo;
    /**
     * 渠道号
     */
    private String channelInto;
    /**
     * 1:未激活，2：已激活
     */
    private String statusConf;
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
    private String testData;
    /**
     * 创建时间
     */
    private Date createdatetime;
    /**
     * 更新时间
     */
    private Date updatetime;



}