package com.bytest.autotest.innerService.impl;

import com.bytest.autotest.aspect.DynamicSource;
import com.bytest.autotest.dao.TesterDao;
import com.bytest.autotest.domain.Tester;
import com.bytest.autotest.enums.DateSourceType;
import com.bytest.autotest.innerService.TesterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <h3>risk-auto-test</h3>
 * <p>用户</p>
 *
 * @author : hh
 * @date : 2020-05-01 23:23
 **/
@Slf4j
@Service
@DynamicSource(dasource = DateSourceType.autotest)
public class TesterServiceImpl implements TesterService {

    @Autowired
    TesterDao testerDao;
    @Override
    public Map check(String username, String password) {
        Tester tester = testerDao.selectByNameAndPwd(username,password);
        Map<String,String> map = new HashMap();
        if (null!=tester){
            map.put("username",username);
            map.put("password",password);
        }else {
            map.put("username","no");
        }
        return map;
    }
}
