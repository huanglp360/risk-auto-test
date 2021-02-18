package com.bytest.autotest.dao;

import com.bytest.autotest.domain.VppVariable;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 变量池表(VppVariable)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-17 11:31:36
 */
public interface VppVariableDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    VppVariable queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<VppVariable> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param vppVariable 实例对象
     * @return 对象列表
     */
    List<VppVariable> queryAll(VppVariable vppVariable);

    /**
     * 新增数据
     *
     * @param vppVariable 实例对象
     * @return 影响行数
     */
    int insert(VppVariable vppVariable);

    /**
     * 修改数据
     *
     * @param vppVariable 实例对象
     * @return 影响行数
     */
    int update(VppVariable vppVariable);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}