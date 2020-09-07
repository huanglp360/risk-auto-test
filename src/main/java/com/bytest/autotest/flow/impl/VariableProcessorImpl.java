package com.bytest.autotest.flow.impl;

import com.bytest.autotest.domain.TaskConfig;
import com.bytest.autotest.dto.AutoResponse;
import com.bytest.autotest.flow.process.VariableProcessor;
import com.bytest.autotest.innerService.TaskConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <h3>risk-auto-test</h3>
 * <p>业务处理</p>
 *
 * @author : hh
 * @date : 2020-09-07 14:15
 **/
@Service
public class VariableProcessorImpl implements VariableProcessor {


    @Autowired
    TaskConfigService taskConfigService;
    @Override
    public AutoResponse excude(TaskConfig task) {
        TaskConfig taskConfig = new TaskConfig();
        taskConfig=taskConfigService.queryById(task.getRequestId());
        return null;
    }
}
