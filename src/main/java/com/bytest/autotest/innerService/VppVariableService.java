package com.bytest.autotest.innerService;

import com.bytest.autotest.domain.VppVariable;

import java.util.List;

/**
 * 变量池表(VppVariable)表服务接口
 *
 * @author makejava
 * @since 2020-08-17 11:31:36
 */
public interface VppVariableService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    VppVariable queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<VppVariable> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param vppVariable 实例对象
     * @return 实例对象
     */
    VppVariable insert(VppVariable vppVariable);

    /**
     * 修改数据
     *
     * @param vppVariable 实例对象
     * @return 实例对象
     */
    VppVariable update(VppVariable vppVariable);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}