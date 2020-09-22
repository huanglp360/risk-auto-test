package com.bytest.autotest.innerService.impl;

import com.bytest.autotest.aspect.DynamicSource;
import com.bytest.autotest.dao.BreEventParamDao;
import com.bytest.autotest.domain.BreEventParam;
import com.bytest.autotest.enums.DateSourceType;
import com.bytest.autotest.innerService.BreEventParamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 策略引擎事件请求和响应参数表(BreEventParam01)表服务实现类
 *
 * @author makejava
 * @since 2020-08-20 16:09:08
 */
@Service("breEventParamService")
@DynamicSource(dasource = DateSourceType.bre)
public class BreEventParamServiceImpl implements BreEventParamService {
    @Resource
    private BreEventParamDao breEventParamDao;



    /**
     * 通过ID查询单条数据
     *
     * @param requestId 主键
     * @return 实例对象
     */

    @Override
    public BreEventParam queryById(String requestId,String day) {
        return this.breEventParamDao.queryById(requestId,day);
    }

    /**
     *
     * @param eventId
     * @param
     * @return
     */
    @Override
    public List<BreEventParam> queryByIdAndDay(String eventId,String day) {
        return this.breEventParamDao.queryByIdAndDay(eventId,day);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<BreEventParam> queryAllByLimit(int offset, int limit,String day) {
        return this.breEventParamDao.queryAllByLimit(offset, limit,day);
    }

    /**
     * 新增数据
     *
     * @param breEventParam 实例对象
     * @return 实例对象
     */
    @Override
    public BreEventParam insert(BreEventParam breEventParam,String day) {
        this.breEventParamDao.insert(breEventParam,day);
        return breEventParam;
    }

    /**
     * 修改数据
     *
     * @param breEventParam 实例对象
     * @return 实例对象
     */
    @Override
    public BreEventParam update(BreEventParam breEventParam,String day) {
        this.breEventParamDao.update(breEventParam,day);
        return this.queryById(breEventParam.getRequestId(),day);
    }

    /**
     * 通过主键删除数据
     *
     * @param requestId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String requestId,String day) {
        return this.breEventParamDao.deleteById(requestId,day) > 0;
    }
}