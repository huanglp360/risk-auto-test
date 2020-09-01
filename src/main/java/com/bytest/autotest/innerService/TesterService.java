package com.bytest.autotest.innerService;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <h3>risk-auto-test</h3>
 * <p>测试用户</p>
 *
 * @author : hh
 * @date : 2020-05-01 23:20
 **/

public interface TesterService {
    public Map check(String username, String password);
}
