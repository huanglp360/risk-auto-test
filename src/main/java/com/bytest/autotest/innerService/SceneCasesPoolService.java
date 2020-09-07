package com.bytest.autotest.innerService;

import com.bytest.autotest.domain.SceneCasesPool;

import java.util.List;

/**
 * (SceneCasesPool)表服务接口
 *
 * @author makejava
 * @since 2020-09-07 11:26:41
 */
public interface SceneCasesPoolService {

    /**
     * 通过ID查询单条数据
     *
     * @param requestId 主键
     * @return 实例对象
     */
    SceneCasesPool queryById(String requestId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SceneCasesPool> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sceneCasesPool 实例对象
     * @return 实例对象
     */
    SceneCasesPool insert(SceneCasesPool sceneCasesPool);

    /**
     * 修改数据
     *
     * @param sceneCasesPool 实例对象
     * @return 实例对象
     */
    SceneCasesPool update(SceneCasesPool sceneCasesPool);

    /**
     * 通过主键删除数据
     *
     * @param requestId 主键
     * @return 是否成功
     */
    boolean deleteById(String requestId);

}