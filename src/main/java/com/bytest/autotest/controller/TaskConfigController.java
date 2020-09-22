package com.bytest.autotest.controller;

import com.bytest.autotest.domain.TaskConfig;
import com.bytest.autotest.innerService.TaskConfigService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试任务表(TaskConfig)表控制层
 *
 * @author makejava
 * @since 2020-09-09 15:52:04
 */
@RestController
@RequestMapping("taskConfig")
public class TaskConfigController {
    /**
     * 服务对象
     */
    @Resource
    private TaskConfigService taskConfigService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TaskConfig selectOne(String id) {
        return this.taskConfigService.queryById(id);
    }

}