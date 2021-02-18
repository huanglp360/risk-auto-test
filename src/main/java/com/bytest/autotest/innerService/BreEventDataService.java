package com.bytest.autotest.innerService;

import com.bytest.autotest.domain.BreEventData;

import java.util.List;

/**
 * 新策略引擎事件表(BreEventData)表服务接口
 *
 * @author makejava
 * @since 2020-08-20 16:05:25
 */
public interface BreEventDataService {

    /**
     * 通过ID查询单条数据
     *
     * @param requestId 主键
     * @return 实例对象
     */
    BreEventData queryById(String requestId);
    List<BreEventData> queryByBusinessId(String busnessId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BreEventData> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param breEventData 实例对象
     * @return 实例对象
     */
    BreEventData insert(BreEventData breEventData);

    /**
     * 修改数据
     *
     * @param breEventData 实例对象
     * @return 实例对象
     */
    BreEventData update(BreEventData breEventData);

    /**
     * 通过主键删除数据
     *
     * @param requestId 主键
     * @return 是否成功
     */
    boolean deleteById(String requestId);

}