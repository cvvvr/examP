package com.exam.entity;

public class CertStudent {
    private Integer certStudentId;
    private Integer certId;
    private Integer studentId;
    private Integer examId;
    private String name;
    private String level;
    private String fangXiang;
    private String examName;

    public CertStudent() {

    }
    public CertStudent(Integer studentId, Integer examId) {
        this.examId = examId;
        this.certId =certId;
    }

    public CertStudent(Integer certId, Integer studentId, Integer examId) {
        this.studentId = studentId;
        this.examId = examId;
        this.certId =certId;
    }

    public CertStudent(Integer certStudentId, Integer studentId, Integer examId, Integer certId,Integer certId2, String name, String level, String fangXiang,Integer examId2, String examName) {
        this.certStudentId = certStudentId;
        this.certId = certId;
        this.studentId = studentId;
        this.examId = examId;
        this.name = name;
        this.level = level;
        this.fangXiang = fangXiang;
        this.examName = examName;
    }

    public Integer getCertId() {
        return certId;
    }

    public void setCertId(Integer certId) {
        this.certId = certId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Integer getCertStudentId() {
        return certStudentId;
    }

    public void setCertStudentId(Integer certStudentId) {
        this.certStudentId = certStudentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getFangXiang() {
        return fangXiang;
    }

    public void setFangXiang(String fangXiang) {
        this.fangXiang = fangXiang;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }
}
