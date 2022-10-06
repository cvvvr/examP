package com.exam.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Cert;
import com.exam.entity.CertStudent;
import com.exam.entity.Student;

public interface CertService {
    IPage<Cert> findAll(Page<Cert> page);

    public Integer addCert(Cert cert);
    public Integer addCertStudent(CertStudent certStudent);
    public Integer updateCert(Cert cert);
    public Integer deleteById(Integer certId);
    public IPage<CertStudent> findAllCertStudent(Page<CertStudent> page);
    public Integer deleteCertStudentById(Integer certStudentId);
}
