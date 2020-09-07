package com.bytest.autotest.innerService.impl;

import com.bytest.autotest.aspect.DynamicSource;
import com.bytest.autotest.dao.ProcessingMappingDao;
import com.bytest.autotest.domain.ProcessingMapping;
import com.bytest.autotest.enums.DateSourceType;
import com.bytest.autotest.innerService.ProcessingMappingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProcessingMapping)表服务实现类
 *
 * @author makejava
 * @since 2020-09-07 11:24:44
 *
 */
@DynamicSource(dasource = DateSourceType.autotest)
@Service("processingMappingService")
public class ProcessingMappingServiceImpl implements ProcessingMappingService {
    @Resource
    private ProcessingMappingDao processingMappingDao;

    /**
     * 通过ID查询单条数据
     *
     * @param requestId 主键
     * @return 实例对象
     */
    @Override
    public ProcessingMapping queryById(String requestId) {
        return this.processingMappingDao.queryById(requestId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<ProcessingMapping> queryAllByLimit(int offset, int limit) {
        return this.processingMappingDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param processingMapping 实例对象
     * @return 实例对象
     */
    @Override
    public ProcessingMapping insert(ProcessingMapping processingMapping) {
        this.processingMappingDao.insert(processingMapping);
        return processingMapping;
    }

    /**
     * 修改数据
     *
     * @param processingMapping 实例对象
     * @return 实例对象
     */
    @Override
    public ProcessingMapping update(ProcessingMapping processingMapping) {
        this.processingMappingDao.update(processingMapping);
        return this.queryById(processingMapping.getRequestId());
    }

    /**
     * 通过主键删除数据
     *
     * @param requestId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String requestId) {
        return this.processingMappingDao.deleteById(requestId) > 0;
    }
}