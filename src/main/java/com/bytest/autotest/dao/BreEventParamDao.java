package com.bytest.autotest.dao;

import com.bytest.autotest.domain.BreEventParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 策略引擎事件请求和响应参数表(BreEventParam01)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-20 16:09:07
 */
public interface BreEventParamDao {

    /**
     * 通过ID查询单条数据
     *
     * @param requestId 主键
     * @return 实例对象
     */
    BreEventParam queryById(String requestId,String day);

    /**
     *
     * @param eventId
     * @param day
     * @return
     */
    List<BreEventParam> queryByIdAndDay(String eventId,String day);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BreEventParam> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit,String day);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param breEventParam 实例对象
     * @return 对象列表
     */
    List<BreEventParam> queryAll(BreEventParam breEventParam,String day);

    /**
     * 新增数据
     *
     * @param breEventParam 实例对象
     * @return 影响行数
     */
    int insert(BreEventParam breEventParam,String day);

    /**
     * 修改数据
     *
     * @param breEventParam 实例对象
     * @return 影响行数
     */
    int update(BreEventParam breEventParam,String day);

    /**
     * 通过主键删除数据
     *
     * @param requestId 主键
     * @return 影响行数
     */
    int deleteById(String requestId,String day);

}