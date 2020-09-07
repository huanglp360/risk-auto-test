package com.bytest.autotest.innerService;

import com.bytest.autotest.domain.VerificationPool;

import java.util.List;

/**
 * (VerificationPool)表服务接口
 *
 * @author makejava
 * @since 2020-09-07 11:30:11
 */
public interface VerificationPoolService {

    /**
     * 通过ID查询单条数据
     *
     * @param requestId 主键
     * @return 实例对象
     */
    VerificationPool queryById(String requestId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<VerificationPool> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param verificationPool 实例对象
     * @return 实例对象
     */
    VerificationPool insert(VerificationPool verificationPool);

    /**
     * 修改数据
     *
     * @param verificationPool 实例对象
     * @return 实例对象
     */
    VerificationPool update(VerificationPool verificationPool);

    /**
     * 通过主键删除数据
     *
     * @param requestId 主键
     * @return 是否成功
     */
    boolean deleteById(String requestId);

}