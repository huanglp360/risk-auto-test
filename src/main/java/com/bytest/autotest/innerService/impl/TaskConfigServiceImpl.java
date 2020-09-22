package com.bytest.autotest.innerService.impl;

import com.bytest.autotest.aspect.DynamicSource;
import com.bytest.autotest.dao.TaskConfigDao;
import com.bytest.autotest.domain.TaskConfig;
import com.bytest.autotest.enums.DateSourceType;
import com.bytest.autotest.innerService.TaskConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 测试任务表(TaskConfig)表服务实现类
 *
 * @author make hh
 * @since 2020-09-09 15:52:04
 */

@Service("taskConfigService")
@DynamicSource(dasource = DateSourceType.autotest)
public class TaskConfigServiceImpl implements TaskConfigService {
    @Resource
    private TaskConfigDao taskConfigDao;

    /**
     * 通过ID查询单条数据
     *
     * @param requestId 主键
     * @return 实例对象
     */
    @Override
    public TaskConfig queryById(String requestId) {
        return this.taskConfigDao.queryById(requestId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TaskConfig> queryAllByLimit(int offset, int limit) {
        return this.taskConfigDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param taskConfig 实例对象
     * @return 实例对象
     */
    @Override
    public TaskConfig insert(TaskConfig taskConfig) {
        this.taskConfigDao.insert(taskConfig);
        return taskConfig;
    }

    /**
     * 修改数据
     *
     * @param taskConfig 实例对象
     * @return 实例对象
     */
    @Override
    public TaskConfig update(TaskConfig taskConfig) {
        this.taskConfigDao.update(taskConfig);
        return this.queryById(taskConfig.getRequestId());
    }

    /**
     * 通过主键删除数据
     *
     * @param requestId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String requestId) {
        return this.taskConfigDao.deleteById(requestId) > 0;
    }
}