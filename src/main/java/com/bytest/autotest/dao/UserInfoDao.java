package com.bytest.autotest.dao;

import com.bytest.autotest.domain.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoDao {

    int deleteByPrimaryKey(Integer id);


    int insert(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);


    List<UserInfo> selectAll();

    List<UserInfo> selectAllNoUsed(@Param("num")String num);

    Integer gettotal();

    List<UserInfo> selectLimt(@Param("page") Integer page, @Param("size") Integer size);

    int updateByPrimaryKey(UserInfo record);
}