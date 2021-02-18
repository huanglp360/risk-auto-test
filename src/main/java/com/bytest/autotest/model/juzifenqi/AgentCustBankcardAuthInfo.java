package com.bytest.autotest.model.juzifenqi;

import lombok.Data;

/**
 * <h3>tool</h3>
 * <p>银行卡信息</p>
 *
 * @author : hh
 * @date : 2020-03-19 23:23
 **/
@Data
public class AgentCustBankcardAuthInfo {
    private String bankCardNo;
    private String bankCardType;
    private String custName;
    private String idType;
    private String idNo;
    private String mobileNo;
}
