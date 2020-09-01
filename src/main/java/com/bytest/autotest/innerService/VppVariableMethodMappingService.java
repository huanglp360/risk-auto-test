package com.bytest.autotest.innerService;

import com.bytest.autotest.domain.VppVariableMethodMapping;

import java.util.List;

/**
 * 策略点变量映射关系表(VppVariableMethodMapping)表服务接口
 *
 * @author makejava
 * @since 2020-08-18 14:43:17
 */
public interface VppVariableMethodMappingService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    VppVariableMethodMapping queryById(String id);

    List<VppVariableMethodMapping> queryBystragetyPoint(String stragetyPoint);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<VppVariableMethodMapping> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param vppVariableMethodMapping 实例对象
     * @return 实例对象
     */
    VppVariableMethodMapping insert(VppVariableMethodMapping vppVariableMethodMapping);

    /**
     * 修改数据
     *
     * @param vppVariableMethodMapping 实例对象
     * @return 实例对象
     */
    VppVariableMethodMapping update(VppVariableMethodMapping vppVariableMethodMapping);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}