package com.bytest.autotest.model;

import lombok.Data;

/**
 * <h3>risk-auto-test</h3>
 * <p>b2b请求对象</p>
 *
 * @author : hh
 * @date : 2020-09-07 14:56
 **/
@Data
public class B2bRequest {
    private CommPO comm;
    String data;
}
