package com.sugar.sugar.mapper;

import com.sugar.sugar.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user" +
            " where username = #{text} or email = #{text}")
    User findUserByNameOrEmail(String text);

    @Select("SELECT * FROM user")
    List<User> SelectAll();
}
