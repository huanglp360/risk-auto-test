package com.bytest.autotest.enums;

/**
 * <h3>risk-auto-test</h3>
 * <p>授信流水</p>
 *
 * @author : hh
 * @date : 2020-09-10 10:38
 **/
public enum RedisKey {
    APPLY_KEY("auto_test_applyno_key","授信流水号"),
    LOAN_KEY("auto_test_loan_key","借款流水号");



    public String code;
    public String desc;

    RedisKey(String code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
