package com.bytest.autotest.innerService.impl;

import com.bytest.autotest.aspect.DynamicSource;
import com.bytest.autotest.dao.TaskCaseMappingDao;
import com.bytest.autotest.domain.TaskCaseMapping;
import com.bytest.autotest.enums.DateSourceType;
import com.bytest.autotest.innerService.TaskCaseMappingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 任务用例映射表(TaskCaseMapping)表服务实现类
 *
 * @author makejava
 * @since 2020-09-09 15:56:11
 */

@Service("taskCaseMappingService")
@DynamicSource(dasource = DateSourceType.autotest)
public class TaskCaseMappingServiceImpl implements TaskCaseMappingService {
    @Resource
    private TaskCaseMappingDao taskCaseMappingDao;

    /**
     * 通过ID查询单条数据
     *
     * @param requestId 主键
     * @return 实例对象
     */
    @Override
    public TaskCaseMapping queryById(String requestId) {
        return this.taskCaseMappingDao.queryById(requestId);
    }

    @Override
    public List<TaskCaseMapping> queryByTaskId(String taskId) {
        return this.taskCaseMappingDao.queryByTaskId(taskId);
    }

    @Override
    public List<TaskCaseMapping> queryAll(TaskCaseMapping taskCaseMapping) {
        return this.taskCaseMappingDao.queryAll(taskCaseMapping);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TaskCaseMapping> queryAllByLimit(int offset, int limit) {
        return this.taskCaseMappingDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param taskCaseMapping 实例对象
     * @return 实例对象
     */
    @Override
    public TaskCaseMapping insert(TaskCaseMapping taskCaseMapping) {
        this.taskCaseMappingDao.insert(taskCaseMapping);
        return taskCaseMapping;
    }

    /**
     * 修改数据
     *
     * @param taskCaseMapping 实例对象
     * @return 实例对象
     */
    @Override
    public TaskCaseMapping update(TaskCaseMapping taskCaseMapping) {
        this.taskCaseMappingDao.update(taskCaseMapping);
        return this.queryById(taskCaseMapping.getRequestId());
    }

    /**
     * 通过主键删除数据
     *
     * @param requestId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String requestId) {
        return this.taskCaseMappingDao.deleteById(requestId) > 0;
    }
}