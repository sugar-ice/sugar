package com.sugar.sugar.controller;

import com.sugar.sugar.entity.RestBean;
import com.sugar.sugar.entity.Student;
import com.sugar.sugar.services.StudentService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Resource
    StudentService studentService;

    @GetMapping("/all")
    public RestBean<List<Student>> all() {
        return RestBean.success(HttpStatus.OK, "ok", studentService.findAllStudent());
    }

}