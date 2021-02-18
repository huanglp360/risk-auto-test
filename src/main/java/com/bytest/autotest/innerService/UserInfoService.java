package com.bytest.autotest.innerService;

import com.bytest.autotest.domain.UserInfo;
import com.bytest.autotest.util.PageResult;
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
public interface UserInfoService {

    public Integer gettotal();
    public UserInfo getUserById(Integer id);
    public List<UserInfo> getall();
    public PageResult getPageResult(Integer page,Integer size,String name,String id_no,String mobile);
    public UserInfo getUserNoused();
    public Integer Update(UserInfo userInfo);
    public Integer inSert(UserInfo userInfo);

}
