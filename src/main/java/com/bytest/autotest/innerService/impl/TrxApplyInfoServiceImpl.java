package com.bytest.autotest.innerService.impl;

import com.bytest.autotest.aspect.DynamicSource;
import com.bytest.autotest.dao.TrxApplyInfoDao;
import com.bytest.autotest.domain.TrxApplyInfo;
import com.bytest.autotest.enums.DateSourceType;
import com.bytest.autotest.innerService.TrxApplyInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 授信申请表(TrxApplyInfo)表服务实现类
 *
 * @author makejava
 * @since 2020-08-27 10:11:22
 */

@Service("trxApplyInfoService")
@DynamicSource(dasource = DateSourceType.crs)
public class TrxApplyInfoServiceImpl implements TrxApplyInfoService {
    @Resource
    private TrxApplyInfoDao trxApplyInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param applyNo 主键
     * @return 实例对象
     */
    @Override
    public TrxApplyInfo queryById(String applyNo) {
        return this.trxApplyInfoDao.queryById(applyNo);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TrxApplyInfo> queryAllByLimit(int offset, int limit) {
        return this.trxApplyInfoDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<TrxApplyInfo> queryNoFinish(Map<String,String> map) {
        List<TrxApplyInfo> list = null;
        for (Map.Entry<String,String> entry:map.entrySet()) {

           TrxApplyInfo tem = trxApplyInfoDao.queryById(entry.getKey());
           if(!tem.getApplyStatus().equals("100") && !tem.getApplyResult().equals("Y")){
               list.add(tem);
           }
        }
        return list;
    }

    /**
     * 新增数据
     *
     * @param trxApplyInfo 实例对象
     * @return 实例对象
     */
    @Override
    public TrxApplyInfo insert(TrxApplyInfo trxApplyInfo) {
        this.trxApplyInfoDao.insert(trxApplyInfo);
        return trxApplyInfo;
    }

    /**
     * 修改数据
     *
     * @param trxApplyInfo 实例对象
     * @return 实例对象
     */
    @Override
    public TrxApplyInfo update(TrxApplyInfo trxApplyInfo) {
        this.trxApplyInfoDao.update(trxApplyInfo);
        return this.queryById(trxApplyInfo.getApplyNo());
    }

    /**
     * 通过主键删除数据
     *
     * @param applyNo 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String applyNo) {
        return this.trxApplyInfoDao.deleteById(applyNo) > 0;
    }
}