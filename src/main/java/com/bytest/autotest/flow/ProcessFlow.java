package com.bytest.autotest.flow;

import java.util.Map;

/**
 * <h3>risk-auto-test</h3>
 * <p>业务执行</p>
 *
 * @author : hh
 * @date : 2020-09-09 15:47
 **/
public interface ProcessFlow {
    public void excuteCredit(String taskId);
    public void excuteLoan(Map<String,String> map);
}
