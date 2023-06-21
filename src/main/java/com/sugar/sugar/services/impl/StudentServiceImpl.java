package com.sugar.sugar.services.impl;

import com.sugar.sugar.entity.Student;
import com.sugar.sugar.mapper.StudentMapper;
import com.sugar.sugar.services.StudentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentMapper studentMapper;
    @Override
    public List<Student> findAllStudent() {
        return studentMapper.findAllStudent();
    }
}
