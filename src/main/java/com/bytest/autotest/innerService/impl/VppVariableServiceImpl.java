package com.bytest.autotest.innerService.impl;

import com.bytest.autotest.aspect.DynamicSource;
import com.bytest.autotest.dao.VppVariableDao;
import com.bytest.autotest.domain.VppVariable;
import com.bytest.autotest.enums.DateSourceType;
import com.bytest.autotest.innerService.VppVariableService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 变量池表(VppVariable)表服务实现类
 *
 * @author makejava
 * @since 2020-08-17 11:31:36
 */
@Service("vppVariableService")
@DynamicSource(dasource = DateSourceType.vpp)
public class VppVariableServiceImpl implements VppVariableService {
    @Resource
    private VppVariableDao vppVariableDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public VppVariable queryById(String id) {
        return this.vppVariableDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<VppVariable> queryAllByLimit(int offset, int limit) {
        return this.vppVariableDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param vppVariable 实例对象
     * @return 实例对象
     */
    @Override
    public VppVariable insert(VppVariable vppVariable) {
        this.vppVariableDao.insert(vppVariable);
        return vppVariable;
    }

    /**
     * 修改数据
     *
     * @param vppVariable 实例对象
     * @return 实例对象
     */
    @Override
    public VppVariable update(VppVariable vppVariable) {
        this.vppVariableDao.update(vppVariable);
        return this.queryById(vppVariable.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.vppVariableDao.deleteById(id) > 0;
    }
}