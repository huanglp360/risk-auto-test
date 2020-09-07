package com.bytest.autotest.controller;

import com.bytest.autotest.domain.VerificationPool;
import com.bytest.autotest.innerService.VerificationPoolService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (VerificationPool)表控制层
 *
 * @author makejava
 * @since 2020-09-07 11:30:12
 */
@RestController
@RequestMapping("verificationPool")
public class VerificationPoolController {
    /**
     * 服务对象
     */
    @Resource
    private VerificationPoolService verificationPoolService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public VerificationPool selectOne(String id) {
        return this.verificationPoolService.queryById(id);
    }

}