package com.bytest.autotest.innerService.impl;

import com.alibaba.fastjson.JSON;
import com.bytest.autotest.aspect.DynamicSource;
import com.bytest.autotest.dao.EasyuiNavDao;
import com.bytest.autotest.domain.EasyuiNav;
import com.bytest.autotest.enums.DateSourceType;
import com.bytest.autotest.innerService.EasyuiNavService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>risk-auto-test</h3>
 * <p>树行结构</p>
 *
 * @author : hh
 * @date : 2020-05-02 15:22
 **/
@Slf4j
@Service
@DynamicSource(dasource = DateSourceType.autotest)
public class EasyuiNavServiceImpl implements EasyuiNavService {
    @Autowired
    EasyuiNavDao easyuiNavDao;
    @Override
    public String getNavListOpen() {
        List<EasyuiNav> listopen = easyuiNavDao.selectOpen("open");
        List<EasyuiNav> listchild= easyuiNavDao.getMenuChildren("close");
//        List<EasyuiNav> temp = new ArrayList<EasyuiNav>();
//        for (EasyuiNav a:listopen) {
//            for (EasyuiNav b:listclosed) {
//                System.out.println("获取到的b的数据"+b.toString());
//                if(a.getId().equals(b.getNid())){
//                    temp.add(b);
//                }
//                System.out.println("temp的数据：："+temp.toString());
//
//            }
//            if(!CollectionUtils.isEmpty(temp)){
//                a.setChildren(temp);
//                temp.clear();
//            }
//            System.out.println("获取到的A的数据为："+a.toString());

        List<EasyuiNav> listall = new ArrayList<>(listopen);
        listall.addAll(listchild);



        String json = JSON.toJSON(listall).toString();
       log.info("获取到的集合{}",json);

        return json;
    }

    @Override
    public String getNavListClosed(String id) {
        List<EasyuiNav> listclosed = easyuiNavDao.selectByNid(Integer.parseInt(id));
        List<EasyuiNav> listall = new ArrayList<>(listclosed);
        String json = JSON.toJSON(listall).toString();
        log.info("获取到的集合{}",json);
        return json;
    }
}
