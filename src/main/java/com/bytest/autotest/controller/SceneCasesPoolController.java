package com.bytest.autotest.controller;

import com.bytest.autotest.domain.SceneCasesPool;
import com.bytest.autotest.innerService.SceneCasesPoolService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (SceneCasesPool)表控制层
 *
 * @author makejava
 * @since 2020-09-07 11:26:41
 */
@RestController
@RequestMapping("sceneCasesPool")
public class SceneCasesPoolController {
    /**
     * 服务对象
     */
    @Resource
    private SceneCasesPoolService sceneCasesPoolService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SceneCasesPool selectOne(String id) {
        return this.sceneCasesPoolService.queryById(id);
    }

}