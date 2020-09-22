package com.bytest.autotest.dao;

import com.bytest.autotest.domain.TaskCaseMapping;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 任务用例映射表(TaskCaseMapping)表数据库访问层
 *
 * @author makejava
 * @since 2020-09-09 15:56:11
 */
public interface TaskCaseMappingDao {

    /**
     * 通过ID查询单条数据
     *
     * @param requestId 主键
     * @return 实例对象
     */
    TaskCaseMapping queryById(String requestId);

    List<TaskCaseMapping> queryByTaskId(String taskId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TaskCaseMapping> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param taskCaseMapping 实例对象
     * @return 对象列表
     */
    List<TaskCaseMapping> queryAll(TaskCaseMapping taskCaseMapping);

    /**
     * 新增数据
     *
     * @param taskCaseMapping 实例对象
     * @return 影响行数
     */
    int insert(TaskCaseMapping taskCaseMapping);

    /**
     * 修改数据
     *
     * @param taskCaseMapping 实例对象
     * @return 影响行数
     */
    int update(TaskCaseMapping taskCaseMapping);

    /**
     * 通过主键删除数据
     *
     * @param requestId 主键
     * @return 影响行数
     */
    int deleteById(String requestId);

}