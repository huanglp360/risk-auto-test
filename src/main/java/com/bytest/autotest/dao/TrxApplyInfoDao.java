package com.bytest.autotest.dao;

import com.bytest.autotest.domain.TrxApplyInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 授信申请表(TrxApplyInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-27 10:11:22
 */
public interface TrxApplyInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param applyNo 主键
     * @return 实例对象
     */
    TrxApplyInfo queryById(String applyNo);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TrxApplyInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);
    List<TrxApplyInfo> queryNoFinish();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param trxApplyInfo 实例对象
     * @return 对象列表
     */
    List<TrxApplyInfo> queryAll(TrxApplyInfo trxApplyInfo);

    /**
     * 新增数据
     *
     * @param trxApplyInfo 实例对象
     * @return 影响行数
     */
    int insert(TrxApplyInfo trxApplyInfo);

    /**
     * 修改数据
     *
     * @param trxApplyInfo 实例对象
     * @return 影响行数
     */
    int update(TrxApplyInfo trxApplyInfo);

    /**
     * 通过主键删除数据
     *
     * @param applyNo 主键
     * @return 影响行数
     */
    int deleteById(String applyNo);

}