package com.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.ApiResult;
import com.exam.entity.Cert;
import com.exam.entity.CertStudent;
import com.exam.entity.Student;
import com.exam.mapper.CertMapper;
import com.exam.mapper.CertStudentMapper;
import com.exam.service.CertService;
import com.exam.serviceimpl.CertServiceImpl;
import com.exam.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CertController {
    @Autowired
    private CertServiceImpl certService;
    @Autowired
    CertMapper certMapper;
    @Autowired
    CertStudentMapper certStudentMapper;

    @PostMapping("/cert")
    public ApiResult addCert(@RequestBody Cert cert){
        int r = certMapper.isBind(cert);
        if(r == 1){
            return ApiResultHandler.buildApiResult(400,"该考试已绑定证书！",null);
        }
        int res = certService.addCert(cert);
        if (res == 1) {
            return ApiResultHandler.buildApiResult(200,"添加成功",null);
        }else {
            return ApiResultHandler.buildApiResult(400,"添加失败",null);
        }
    }
    @PostMapping("/addCertStudentByExam")
    public ApiResult addCertStudentByExam(@RequestBody CertStudent certStudent){
        int certId = certStudentMapper.getCertIdByExamId(certStudent);
        certStudent.setCertId(certId);
        int res = certService.addCertStudent(certStudent);
        if (res == 1) {
            return ApiResultHandler.buildApiResult(200,"添加成功",null);
        }else {
            return ApiResultHandler.buildApiResult(400,"添加失败",null);
        }
    }



    @PutMapping("/cert")
    public ApiResult update(@RequestBody Cert cert) {
        int res = certService.updateCert(cert);
        if (res != 0) {
            return ApiResultHandler.buildApiResult(200,"更新成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"更新失败",res);
    }
    @DeleteMapping("/cert/{certId}")
    public ApiResult deleteById(@PathVariable("certId") Integer certId) {
        return ApiResultHandler.buildApiResult(200,"删除成功",certService.deleteById(certId));
    }
    @DeleteMapping("/certStudent/{certStudentId}")
    public ApiResult deleteCertStudentById(@PathVariable("certStudentId") Integer certStudentId) {
        return ApiResultHandler.buildApiResult(200,"删除成功",certService.deleteCertStudentById(certStudentId));
    }

    @PostMapping("/certStudent")
    public ApiResult addCertStudent(@RequestBody CertStudent certStudent){
        int res = certService.addCertStudent(certStudent);
        if (res == 1) {
            return ApiResultHandler.buildApiResult(200,"添加成功",null);
        }else {
            return ApiResultHandler.buildApiResult(400,"添加失败",null);
        }
    }

    @GetMapping("/certs/{page}/{size}")
    public ApiResult findAll(@PathVariable Integer page, @PathVariable Integer size) {
        Page<Cert> certPage = new Page<>(page,size);
        IPage<Cert> res = certService.findAll(certPage);
        return  ApiResultHandler.buildApiResult(200,"分页查询所有证书",res);
    }
    @GetMapping("/certs/{studentId}")
    public ApiResult getCertsByStudentId(@PathVariable Integer studentId) {
        return  ApiResultHandler.buildApiResult(200,"查询所有已获得证书",certStudentMapper.findByStudentId(studentId));
    }


    @GetMapping("/certStudents/{page}/{size}")
    public ApiResult findAllCertStudent(@PathVariable Integer page, @PathVariable Integer size) {
        Page<CertStudent> certStudentPage = new Page<>(page,size);
        IPage<CertStudent> res = certService.findAllCertStudent(certStudentPage);
        return  ApiResultHandler.buildApiResult(200,"分页查询所有获取证书",res);
    }


}
