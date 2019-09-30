package com.evaluate.demo.entity;

public class Statistics {
    private int uid;
    private int evaluates_id;
    private String student_score;
    private String self_score;
    private String peer_score;
    private String leader_score;
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

    public String getStudent_score() {
        return student_score;
    }

    public void setStudent_score(String student_score) {
        this.student_score = student_score;
    }

    public String getSelf_score() {
        return self_score;
    }

    public void setSelf_score(String self_score) {
        this.self_score = self_score;
    }

    public String getPeer_score() {
        return peer_score;
    }

    public void setPeer_score(String peer_score) {
        this.peer_score = peer_score;
    }

    public String getLeader_score() {
        return leader_score;
    }

    public void setLeader_score(String leader_score) {
        this.leader_score = leader_score;
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
