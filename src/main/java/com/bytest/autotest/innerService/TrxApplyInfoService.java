package com.bytest.autotest.innerService;

import com.bytest.autotest.domain.TrxApplyInfo;

import java.util.List;

/**
 * 授信申请表(TrxApplyInfo)表服务接口
 *
 * @author makejava
 * @since 2020-08-27 10:11:22
 */
public interface TrxApplyInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param applyNo 主键
     * @return 实例对象
     */
    TrxApplyInfo queryById(String applyNo);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TrxApplyInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param trxApplyInfo 实例对象
     * @return 实例对象
     */
    TrxApplyInfo insert(TrxApplyInfo trxApplyInfo);

    /**
     * 修改数据
     *
     * @param trxApplyInfo 实例对象
     * @return 实例对象
     */
    TrxApplyInfo update(TrxApplyInfo trxApplyInfo);

    /**
     * 通过主键删除数据
     *
     * @param applyNo 主键
     * @return 是否成功
     */
    boolean deleteById(String applyNo);

}