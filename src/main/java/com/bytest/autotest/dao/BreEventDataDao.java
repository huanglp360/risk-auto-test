package com.bytest.autotest.dao;

import com.bytest.autotest.domain.BreEventData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 新策略引擎事件表(BreEventData)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-20 16:05:25
 */
public interface BreEventDataDao {

    /**
     * 通过ID查询单条数据
     *
     * @param requestId 主键
     * @return 实例对象
     */
    BreEventData queryById(String requestId);

    List<BreEventData> queryByBusinessId(String busnessId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BreEventData> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param breEventData 实例对象
     * @return 对象列表
     */
    List<BreEventData> queryAll(BreEventData breEventData);

    /**
     * 新增数据
     *
     * @param breEventData 实例对象
     * @return 影响行数
     */
    int insert(BreEventData breEventData);

    /**
     * 修改数据
     *
     * @param breEventData 实例对象
     * @return 影响行数
     */
    int update(BreEventData breEventData);

    /**
     * 通过主键删除数据
     *
     * @param requestId 主键
     * @return 影响行数
     */
    int deleteById(String requestId);

}