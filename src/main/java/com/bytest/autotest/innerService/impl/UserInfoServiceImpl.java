package com.bytest.autotest.innerService.impl;

import com.bytest.autotest.aspect.DynamicSource;
import com.bytest.autotest.dao.UserInfoDao;
import com.bytest.autotest.domain.UserInfo;
import com.bytest.autotest.enums.DateSourceType;
import com.bytest.autotest.innerService.UserInfoService;
import com.bytest.autotest.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h3>risk-auto-test</h3>
 * <p>测试数据</p>
 *
 * @author : hh
 * @date : 2020-05-04 02:41
 **/
@Service
@DynamicSource(dasource = DateSourceType.autotest)
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoDao userInfoDao;

    @Override
    public Integer gettotal() {
        return userInfoDao.gettotal();
    }

    @Override
    public List getall() {
        return userInfoDao.selectAll();
            }

    @Override
    public PageResult getPageResult(Integer page, Integer size) {
        PageResult pageResult = new PageResult();
        pageResult.setTotle(gettotal());

        List list = userInfoDao.selectLimt((page-1)*size,size);
        pageResult.setRows(list);
        return pageResult;
    }

    @Override
    public UserInfo getUserNoused() {
        return userInfoDao.selectAllNoUsed("0").get(0);
    }

    @Override
    public Integer Update(UserInfo info) {
        return userInfoDao.updateByPrimaryKey(info);
    }

    @Override
    public Integer inSert(UserInfo userInfo) {
        return userInfoDao.insert(userInfo);
    }

}
