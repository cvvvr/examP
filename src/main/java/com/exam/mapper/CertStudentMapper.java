package com.exam.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Cert;
import com.exam.entity.CertStudent;
import com.exam.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CertStudentMapper {
    /**
     * 根据学生ID获取证书
     */
    @Select("select * from certStudent left join cert on certStudent.certId = cert.certId where studentId = #{studentId}")
    List<CertStudent> findByStudentId(Integer studentId);

    /**
     * 新增证书
     */
    @Options(useGeneratedKeys = true,keyProperty = "certStudentId")
    @Insert("insert into certStudent(studentId,examId,certId) values " +
            "(#{studentId},#{examId},#{certId})")
    int addCertStudent(CertStudent certStudent);

    @Select("select * from certStudent left join cert on certStudent.certId = cert.certId")
    IPage<CertStudent> findAllCertStudent(Page page);

    @Delete("delete from certStudent where certStudentId = #{certStudentId}")
    int deleteCertStudentById(Integer certStudentId);

    @Select("select certId from cert where examId = #{examId}")
    Integer getCertIdByExamId(CertStudent certStudent);
}
