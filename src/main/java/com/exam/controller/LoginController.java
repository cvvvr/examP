package com.exam.controller;

import com.exam.entity.*;
import com.exam.serviceimpl.LoginServiceImpl;
import com.exam.serviceimpl.StudentServiceImpl;
import com.exam.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;
    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping("/login")
    public ApiResult login(@RequestBody Login login) {

        String username = login.getUsername();
        String password = login.getPassword();
        Admin adminRes = loginService.adminLogin(username, password);
        if (adminRes != null) {
            return ApiResultHandler.buildApiResult(200, "请求成功", adminRes);
        }

        Teacher teacherRes = loginService.teacherLogin(username,password);
        if (teacherRes != null) {
            return ApiResultHandler.buildApiResult(200, "请求成功", teacherRes);
        }

        Student studentRes = loginService.studentLogin(username,password);
        if (studentRes != null) {
            return ApiResultHandler.buildApiResult(200, "请求成功", studentRes);
        }

        return ApiResultHandler.buildApiResult(400, "请求失败", null);
    }

    @PostMapping("/register")
    public ApiResult register(@RequestBody Student student) {

        Integer res = studentService.add(student);
        if (res == 1) {
            return ApiResultHandler.buildApiResult(200,"注册成功",null);
        }else {
            return ApiResultHandler.buildApiResult(400,"注册失败",null);
        }
    }
}
