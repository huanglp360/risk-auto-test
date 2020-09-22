package com.bytest.autotest.controller;

import com.bytest.autotest.domain.TaskCaseMapping;
import com.bytest.autotest.innerService.TaskCaseMappingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 任务用例映射表(TaskCaseMapping)表控制层
 *
 * @author makejava
 * @since 2020-09-09 15:56:11
 */
@RestController
@RequestMapping("taskCaseMapping")
public class TaskCaseMappingController {
    /**
     * 服务对象
     */
    @Resource
    private TaskCaseMappingService taskCaseMappingService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TaskCaseMapping selectOne(String id) {
        return this.taskCaseMappingService.queryById(id);
    }

}