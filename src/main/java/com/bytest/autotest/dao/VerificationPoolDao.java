package com.bytest.autotest.dao;

import com.bytest.autotest.domain.VerificationPool;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (VerificationPool)表数据库访问层
 *
 * @author makejava
 * @since 2020-09-07 11:30:11
 */
public interface VerificationPoolDao {

    /**
     * 通过ID查询单条数据
     *
     * @param requestId 主键
     * @return 实例对象
     */
    VerificationPool queryById(String requestId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<VerificationPool> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param verificationPool 实例对象
     * @return 对象列表
     */
    List<VerificationPool> queryAll(VerificationPool verificationPool);

    /**
     * 新增数据
     *
     * @param verificationPool 实例对象
     * @return 影响行数
     */
    int insert(VerificationPool verificationPool);

    /**
     * 修改数据
     *
     * @param verificationPool 实例对象
     * @return 影响行数
     */
    int update(VerificationPool verificationPool);

    /**
     * 通过主键删除数据
     *
     * @param requestId 主键
     * @return 影响行数
     */
    int deleteById(String requestId);

}