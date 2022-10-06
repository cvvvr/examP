package com.exam.serviceimpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Cert;
import com.exam.entity.CertStudent;
import com.exam.entity.Student;
import com.exam.mapper.CertMapper;
import com.exam.mapper.CertStudentMapper;
import com.exam.service.CertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertServiceImpl implements CertService {

    @Autowired
    CertMapper certMapper;
    @Autowired
    CertStudentMapper certStudentMapper;

    @Override
    public IPage<Cert> findAll(Page<Cert> page) {
        return certMapper.findAll(page);
    }

    @Override
    public Integer addCert(Cert cert) {
        return certMapper.addCert(cert);
    }

    @Override
    public Integer addCertStudent(CertStudent certStudent) {
        return certStudentMapper.addCertStudent(certStudent);
    }

    @Override
    public Integer updateCert(Cert cert) {
        return certMapper.updateCert(cert);
    }

    @Override
    public Integer deleteById(Integer certId) {
        return certMapper.deleteById(certId);
    }

    @Override
    public IPage<CertStudent> findAllCertStudent(Page<CertStudent> page) {
        return certStudentMapper.findAllCertStudent(page);
    }

    @Override
    public Integer deleteCertStudentById(Integer certStudentId) {
        return certStudentMapper.deleteCertStudentById(certStudentId);
    }
}
