package com.sugar.sugar.mapper;

import com.sugar.sugar.entity.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AccountMapper {
    @Select("SELECT * FROM user u join role r on u.role_id = r.role_id" +
            " where u.username = #{text} or u.email = #{text}")
    Account findAccountByNameOrEmail(String text);

    @Insert("insert into user (username, password, email, role_id) values " +
            "(#{userName}, #{password}, #{email}, " +
            "(SELECT role_id FROM role WHERE role_name = #{roleName}))")
    int createAccount(String userName, String password, String email, String roleName);

    @Update("update db_account set password = #{password} where email = #{email}")
    int resetPasswordByEmail(String email, String password);
}
