package com.bytest.autotest.innerService.impl;

import com.bytest.autotest.aspect.DynamicSource;
import com.bytest.autotest.dao.BreEventDataDao;
import com.bytest.autotest.domain.BreEventData;
import com.bytest.autotest.enums.DateSourceType;
import com.bytest.autotest.innerService.BreEventDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 新策略引擎事件表(BreEventData)表服务实现类
 *
 * @author makejava
 * @since 2020-08-20 16:05:26
 */
@Service("breEventDataService")
@DynamicSource(dasource = DateSourceType.bre)
public class BreEventDataServiceImpl implements BreEventDataService {
    @Resource
    private BreEventDataDao breEventDataDao;

    /**
     * 通过ID查询单条数据
     *
     * @param requestId 主键
     * @return 实例对象
     */
    @Override
    public BreEventData queryById(String requestId) {
        return this.breEventDataDao.queryById(requestId);
    }

    @Override
    public List<BreEventData> queryByBusinessId(String busnessId) {
        return breEventDataDao.queryByBusinessId(busnessId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<BreEventData> queryAllByLimit(int offset, int limit) {
        return this.breEventDataDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param breEventData 实例对象
     * @return 实例对象
     */
    @Override
    public BreEventData insert(BreEventData breEventData) {
        this.breEventDataDao.insert(breEventData);
        return breEventData;
    }

    /**
     * 修改数据
     *
     * @param breEventData 实例对象
     * @return 实例对象
     */
    @Override
    public BreEventData update(BreEventData breEventData) {
        this.breEventDataDao.update(breEventData);
        return this.queryById(breEventData.getRequestId());
    }

    /**
     * 通过主键删除数据
     *
     * @param requestId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String requestId) {
        return this.breEventDataDao.deleteById(requestId) > 0;
    }
}