package com.bytest.autotest.innerService.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytest.autotest.aspect.DynamicSource;
import com.bytest.autotest.dao.SceneCasesPoolDao;
import com.bytest.autotest.domain.SceneCasesPool;
import com.bytest.autotest.enums.DateSourceType;
import com.bytest.autotest.innerService.SceneCasesPoolService;
import com.bytest.autotest.model.B2bRequest;
import com.bytest.autotest.model.CommPO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 场景测试用例表(SceneCasesPool)表服务实现类
 *
 * @author makejava
 * @since 2020-09-09 16:13:13
 */

@Service("sceneCasesPoolService")
@DynamicSource(dasource = DateSourceType.autotest)
public class SceneCasesPoolServiceImpl implements SceneCasesPoolService {
    @Resource
    private SceneCasesPoolDao sceneCasesPoolDao;

    /**
     * 通过ID查询单条数据
     *
     * @param requestId 主键
     * @return 实例对象
     */
    @Override
    public SceneCasesPool queryById(String requestId) {
        return this.sceneCasesPoolDao.queryById(requestId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SceneCasesPool> queryAllByLimit(int offset, int limit) {
        return this.sceneCasesPoolDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sceneCasesPool 实例对象
     * @return 实例对象
     */
    @Override
    public SceneCasesPool insert(SceneCasesPool sceneCasesPool) {
        this.sceneCasesPoolDao.insert(sceneCasesPool);
        String data = sceneCasesPool.getTestData();
        JSONObject jsonObject = JSON.parseObject(data);
        B2bRequest b2bRequest = new B2bRequest();
        CommPO commPO = new CommPO();
        commPO = jsonObject.getObject("comm",CommPO.class);
        //TODO 测试用例存储到mongo


        return sceneCasesPool;
    }

    /**
     * 修改数据
     *
     * @param sceneCasesPool 实例对象
     * @return 实例对象
     */
    @Override
    public SceneCasesPool update(SceneCasesPool sceneCasesPool) {
        this.sceneCasesPoolDao.update(sceneCasesPool);
        return this.queryById(sceneCasesPool.getRequestId());
    }

    /**
     * 通过主键删除数据
     *
     * @param requestId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String requestId) {
        return this.sceneCasesPoolDao.deleteById(requestId) > 0;
    }
}