package com.exam.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Cert;
import com.exam.entity.Student;
import com.exam.entity.StudentExam;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CertMapper {
    /**
     * 新增证书
     */
    @Options(useGeneratedKeys = true,keyProperty = "certId")
    @Insert("insert into cert(certId,name,level,fangXiang,examId,examName) values " +
            "(#{certId},#{name},#{level},#{fangXiang},#{examId},#{examName})")
    int addCert(Cert cert);

    @Select("select count(1) from cert where examId = #{examId}")
    int isBind(Cert cert);

    /**
     * 分页查询所有证书
     * @param page
     * @return List<Cert>
     */
    @Select("select * from cert")
    IPage<Cert> findAll(Page page);

    /**
     * 更新证书
     */
    @Update("update cert set name = #{name},level = #{level},fangXiang = #{fangXiang}")
    int updateCert(Cert cert);

    @Delete("delete from cert where certId = #{certId}")
    int deleteById(Integer certId);
}
