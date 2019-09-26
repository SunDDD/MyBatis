package com.mybatis.dao;

import com.mybatis.domain.User;
import com.mybatis.mybatis.annotations.Select;

import java.util.List;

public interface IUserDao {
    @Select("select * from user")
    List<User> findAll();
}
