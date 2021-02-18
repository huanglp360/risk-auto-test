package com.bytest.autotest.dao;

import com.bytest.autotest.domain.Tester;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TesterDao {

    int deleteByPrimaryKey(Integer id);


    int insert(Tester record);


    Tester selectByPrimaryKey(Integer id);

    Tester selectByNameAndPwd(@Param("username") String username, @Param("password")String password);


    List<Tester> selectAll();



    int updateByPrimaryKey(Tester record);
}