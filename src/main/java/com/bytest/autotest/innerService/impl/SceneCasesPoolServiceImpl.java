package com.bytest.autotest.innerService.impl;

import com.bytest.autotest.aspect.DynamicSource;
import com.bytest.autotest.dao.SceneCasesPoolDao;
import com.bytest.autotest.domain.SceneCasesPool;
import com.bytest.autotest.enums.DateSourceType;
import com.bytest.autotest.innerService.SceneCasesPoolService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SceneCasesPool)表服务实现类
 *
 * @author makejava
 * @since 2020-09-07 11:26:41
 */
@DynamicSource(dasource = DateSourceType.autotest)
@Service("sceneCasesPoolService")
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