package com.bytest.autotest.innerService.impl;

import com.bytest.autotest.aspect.DynamicSource;
import com.bytest.autotest.dao.VppVariableMethodMappingDao;
import com.bytest.autotest.domain.VppVariableMethodMapping;
import com.bytest.autotest.enums.DateSourceType;
import com.bytest.autotest.innerService.VppVariableMethodMappingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 策略点变量映射关系表(VppVariableMethodMapping)表服务实现类
 *
 * @author makejava
 * @since 2020-08-18 14:43:18
 */
@Service("vppVariableMethodMappingService")
@DynamicSource(dasource = DateSourceType.vpp)
public class VppVariableMethodMappingServiceImpl implements VppVariableMethodMappingService {
    @Resource
    private VppVariableMethodMappingDao vppVariableMethodMappingDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public VppVariableMethodMapping queryById(String id) {
        return this.vppVariableMethodMappingDao.queryById(id);
    }

    @Override
    public List<VppVariableMethodMapping> queryBystragetyPoint(String stragetyPoint) {
        return this.vppVariableMethodMappingDao.queryBystragetyPoint(stragetyPoint);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<VppVariableMethodMapping> queryAllByLimit(int offset, int limit) {
        return this.vppVariableMethodMappingDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param vppVariableMethodMapping 实例对象
     * @return 实例对象
     */
    @Override
    public VppVariableMethodMapping insert(VppVariableMethodMapping vppVariableMethodMapping) {
        this.vppVariableMethodMappingDao.insert(vppVariableMethodMapping);
        return vppVariableMethodMapping;
    }

    /**
     * 修改数据
     *
     * @param vppVariableMethodMapping 实例对象
     * @return 实例对象
     */
    @Override
    public VppVariableMethodMapping update(VppVariableMethodMapping vppVariableMethodMapping) {
        this.vppVariableMethodMappingDao.update(vppVariableMethodMapping);
        return this.queryById(vppVariableMethodMapping.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.vppVariableMethodMappingDao.deleteById(id) > 0;
    }
}