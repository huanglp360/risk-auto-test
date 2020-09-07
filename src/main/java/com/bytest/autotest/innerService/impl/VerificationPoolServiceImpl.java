package com.bytest.autotest.innerService.impl;

import com.bytest.autotest.aspect.DynamicSource;
import com.bytest.autotest.dao.VerificationPoolDao;
import com.bytest.autotest.domain.VerificationPool;
import com.bytest.autotest.enums.DateSourceType;
import com.bytest.autotest.innerService.VerificationPoolService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (VerificationPool)表服务实现类
 *
 * @author makejava
 * @since 2020-09-07 11:30:11
 */
@DynamicSource(dasource = DateSourceType.autotest)
@Service("verificationPoolService")
public class VerificationPoolServiceImpl implements VerificationPoolService {
    @Resource
    private VerificationPoolDao verificationPoolDao;

    /**
     * 通过ID查询单条数据
     *
     * @param requestId 主键
     * @return 实例对象
     */
    @Override
    public VerificationPool queryById(String requestId) {
        return this.verificationPoolDao.queryById(requestId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<VerificationPool> queryAllByLimit(int offset, int limit) {
        return this.verificationPoolDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param verificationPool 实例对象
     * @return 实例对象
     */
    @Override
    public VerificationPool insert(VerificationPool verificationPool) {
        this.verificationPoolDao.insert(verificationPool);
        return verificationPool;
    }

    /**
     * 修改数据
     *
     * @param verificationPool 实例对象
     * @return 实例对象
     */
    @Override
    public VerificationPool update(VerificationPool verificationPool) {
        this.verificationPoolDao.update(verificationPool);
        return this.queryById(verificationPool.getRequestId());
    }

    /**
     * 通过主键删除数据
     *
     * @param requestId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String requestId) {
        return this.verificationPoolDao.deleteById(requestId) > 0;
    }
}