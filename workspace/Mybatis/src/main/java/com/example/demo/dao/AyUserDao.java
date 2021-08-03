package com.example.demo.dao;

import com.example.demo.model.AyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AyUserDao {
    //    通过用户名密码查询用户
    AyUser FindByNameAndPassword(@Param("id") String id);

    AyUser FindById(@Param("id") String id);


}
