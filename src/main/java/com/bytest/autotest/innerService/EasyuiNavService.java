package com.bytest.autotest.innerService;

import com.bytest.autotest.domain.EasyuiNav;

import java.util.List;

/**
 * <h3>risk-auto-test</h3>
 * <p>树形结构</p>
 *
 * @author : hh
 * @date : 2020-05-02 15:21
 **/
public interface EasyuiNavService {
    public String getNavListOpen();
    public String getNavListClosed(String id);

}
