package com.bytest.autotest.model.juzifenqi;

import lombok.Data;

/**
 * <h3>tool</h3>
 * <p>借款数据</p>
 *
 * @author : hh
 * @date : 2020-03-19 23:20
 **/
@Data
public class LoanInfo {
    private String repayInterval;
    private String firstPayDate;
    private String transAmt;
    private String totalCnt;
    private String repayMethod;
    private String loanUse;
}
