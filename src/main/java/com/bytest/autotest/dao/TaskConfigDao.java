package com.bytest.autotest.dao;

import com.bytest.autotest.domain.TaskConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TaskConfig)表数据库访问层
 *
 * @author makejava
 * @since 2020-09-07 11:29:53
 */
public interface TaskConfigDao {

    /**
     * 通过ID查询单条数据
     *
     * @param requestId 主键
     * @return 实例对象
     */
    TaskConfig queryById(String requestId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TaskConfig> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param taskConfig 实例对象
     * @return 对象列表
     */
    List<TaskConfig> queryAll(TaskConfig taskConfig);

    /**
     * 新增数据
     *
     * @param taskConfig 实例对象
     * @return 影响行数
     */
    int insert(TaskConfig taskConfig);

    /**
     * 修改数据
     *
     * @param taskConfig 实例对象
     * @return 影响行数
     */
    int update(TaskConfig taskConfig);

    /**
     * 通过主键删除数据
     *
     * @param requestId 主键
     * @return 影响行数
     */
    int deleteById(String requestId);

}