package com.bytest.autotest.innerService;

import com.bytest.autotest.domain.TaskCaseMapping;

import java.util.List;

/**
 * 任务用例映射表(TaskCaseMapping)表服务接口
 *
 * @author makejava
 * @since 2020-09-09 15:56:11
 */
public interface TaskCaseMappingService {

    /**
     * 通过ID查询单条数据
     *
     * @param requestId 主键
     * @return 实例对象
     */
    TaskCaseMapping queryById(String requestId);

    List<TaskCaseMapping> queryByTaskId(String taskId);

    List<TaskCaseMapping> queryAll(TaskCaseMapping taskCaseMapping);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TaskCaseMapping> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param taskCaseMapping 实例对象
     * @return 实例对象
     */
    TaskCaseMapping insert(TaskCaseMapping taskCaseMapping);

    /**
     * 修改数据
     *
     * @param taskCaseMapping 实例对象
     * @return 实例对象
     */
    TaskCaseMapping update(TaskCaseMapping taskCaseMapping);

    /**
     * 通过主键删除数据
     *
     * @param requestId 主键
     * @return 是否成功
     */
    boolean deleteById(String requestId);

}