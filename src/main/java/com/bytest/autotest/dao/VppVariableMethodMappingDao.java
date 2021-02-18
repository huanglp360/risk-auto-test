package com.bytest.autotest.dao;

import com.bytest.autotest.domain.VppVariableMethodMapping;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 策略点变量映射关系表(VppVariableMethodMapping)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-18 14:43:02
 */
public interface VppVariableMethodMappingDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    VppVariableMethodMapping queryById(String id);

    List<VppVariableMethodMapping> queryBystragetyPoint(String stragetyPoint);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<VppVariableMethodMapping> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param vppVariableMethodMapping 实例对象
     * @return 对象列表
     */
    List<VppVariableMethodMapping> queryAll(VppVariableMethodMapping vppVariableMethodMapping);

    /**
     * 新增数据
     *
     * @param vppVariableMethodMapping 实例对象
     * @return 影响行数
     */
    int insert(VppVariableMethodMapping vppVariableMethodMapping);

    /**
     * 修改数据
     *
     * @param vppVariableMethodMapping 实例对象
     * @return 影响行数
     */
    int update(VppVariableMethodMapping vppVariableMethodMapping);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}