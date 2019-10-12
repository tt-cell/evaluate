package com.evaluate.demo.entity;

public class EvaluateResult {
    private int  ResultId;
    private int batch_id;
    private String userName;
    private String teacherName;
    private String courses_name;
    private int evaluates_id;
    private float totalscore;

    public int getResultId() {
        return ResultId;
    }

    public void setResultId(int resultId) {
        ResultId = resultId;
    }

    public int getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(int batch_id) {
        this.batch_id = batch_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getCourses_name() {
        return courses_name;
    }

    public void setCourses_name(String courses_name) {
        this.courses_name = courses_name;
    }

    public int getEvaluates_id() {
        return evaluates_id;
    }

    public void setEvaluates_id(int evaluates_id) {
        this.evaluates_id = evaluates_id;
    }

    public float getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(float totalscore) {
        this.totalscore = totalscore;
    }
}
