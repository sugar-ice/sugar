package com.sugar.sugar.mapper;

import com.sugar.sugar.entity.Account;
import com.sugar.sugar.entity.Student;
import com.sugar.sugar.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("SELECT * FROM student")
    List<Student> findAllStudent();
}
