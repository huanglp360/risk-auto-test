package com.bytest.autotest.controller;

import com.bytest.autotest.domain.ProcessingMapping;
import com.bytest.autotest.innerService.ProcessingMappingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (ProcessingMapping)表控制层
 *
 * @author makejava
 * @since 2020-09-07 11:24:45
 */
@RestController
@RequestMapping("processingMapping")
public class ProcessingMappingController {
    /**
     * 服务对象
     */
    @Resource
    private ProcessingMappingService processingMappingService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ProcessingMapping selectOne(String id) {
        return this.processingMappingService.queryById(id);
    }

}