package com.exam.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Student;
import com.exam.entity.StudentExam;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface StudentService {

    IPage<Student> findAll(Page<Student> page);

    Student findById(Integer studentId);

    int deleteById(Integer studentId);

    int update(Student student);

    int updatePwd(Student student);
    int add(Student student);
    int signUp(StudentExam studentExam);
    int isSignUp(StudentExam studentExam);
    List<Integer> findSignUpBystudentId(Integer studentId);
}
