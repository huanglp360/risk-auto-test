package com.bytest.autotest.innerService;

import com.bytest.autotest.domain.BreEventParam;

import java.util.List;

/**
 * 策略引擎事件请求和响应参数表(BreEventParam)表服务接口
 *
 * @author makejava
 * @since 2020-08-20 16:09:08
 */
public interface BreEventParamService {

    /**
     * 通过ID查询单条数据
     *
     * @param requestId 主键
     * @return 实例对象
     */
    BreEventParam queryById(String requestId,String day);

    List<BreEventParam> queryByIdAndDay(String eventId,String day);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BreEventParam> queryAllByLimit(int offset, int limit,String day);

    /**
     * 新增数据
     *
     * @param breEventParam 实例对象
     * @return 实例对象
     */
    BreEventParam insert(BreEventParam breEventParam,String day);

    /**
     * 修改数据
     *
     * @param breEventParam 实例对象
     * @return 实例对象
     */
    BreEventParam update(BreEventParam breEventParam,String day);

    /**
     * 通过主键删除数据
     *
     * @param requestId 主键
     * @return 是否成功
     */
    boolean deleteById(String requestId,String day);

}