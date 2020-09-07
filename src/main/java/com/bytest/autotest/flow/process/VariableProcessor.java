package com.bytest.autotest.flow.process;

import com.bytest.autotest.domain.TaskConfig;
import com.bytest.autotest.dto.AutoResponse;

/**
 * <h3>risk-auto-test</h3>
 * <p>变量处理</p>
 *
 * @author : hh
 * @date : 2020-09-07 09:50
 **/
public interface VariableProcessor {
    public AutoResponse excude(TaskConfig task);
}
