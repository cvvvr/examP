package com.exam.entity;

public class Cert {
    private Integer certId;
    private String name;
    private String level;
    private String fangXiang;
    private Integer examId;
    private String examName;

    public Cert(Integer certId, String name, String level, String fangXiang,Integer examId,String examName) {
        this.certId = certId;
        this.name = name;
        this.level = level;
        this.fangXiang = fangXiang;
        this.examId = examId;
        this.examName = examName;
    }

    public Integer getCertId() {
        return certId;
    }

    public void setCertId(Integer certId) {
        this.certId = certId;
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

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }
}
