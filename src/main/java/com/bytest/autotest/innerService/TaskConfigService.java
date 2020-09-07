package com.bytest.autotest.innerService;

import com.bytest.autotest.domain.TaskConfig;

import java.util.List;

/**
 * (TaskConfig)表服务接口
 *
 * @author makejava
 * @since 2020-09-07 11:29:53
 */
public interface TaskConfigService {

    /**
     * 通过ID查询单条数据
     *
     * @param requestId 主键
     * @return 实例对象
     */
    TaskConfig queryById(String requestId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TaskConfig> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param taskConfig 实例对象
     * @return 实例对象
     */
    TaskConfig insert(TaskConfig taskConfig);

    /**
     * 修改数据
     *
     * @param taskConfig 实例对象
     * @return 实例对象
     */
    TaskConfig update(TaskConfig taskConfig);

    /**
     * 通过主键删除数据
     *
     * @param requestId 主键
     * @return 是否成功
     */
    boolean deleteById(String requestId);

}