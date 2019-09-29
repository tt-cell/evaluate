package com.evaluate.demo.entity;

public class Statistics {
    private int uid;
    private int evaluates_id;
    private String score;
    private int courses_id;
    private String note;
    private String uname;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getEvaluates_id() {
        return evaluates_id;
    }

    public void setEvaluates_id(int evaluates_id) {
        this.evaluates_id = evaluates_id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getCourses_id() {
        return courses_id;
    }

    public void setCourses_id(int courses_id) {
        this.courses_id = courses_id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
