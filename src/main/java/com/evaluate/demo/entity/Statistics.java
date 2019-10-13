package com.evaluate.demo.entity;

public class Statistics {
    private float score;
    private int batch_id;
    private int uid;
    private String teacherName;
    private float student_sum;
    private float self_sum;
    private float peer_sum;
    private float leader_sum;

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(int batch_id) {
        this.batch_id = batch_id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public float getStudent_sum() {
        return student_sum;
    }

    public void setStudent_sum(float student_sum) {
        this.student_sum = student_sum;
    }

    public float getSelf_sum() {
        return self_sum;
    }

    public void setSelf_sum(float self_sum) {
        this.self_sum = self_sum;
    }

    public float getPeer_sum() {
        return peer_sum;
    }

    public void setPeer_sum(float peer_sum) {
        this.peer_sum = peer_sum;
    }

    public float getLeader_sum() {
        return leader_sum;
    }

    public void setLeader_sum(float leader_sum) {
        this.leader_sum = leader_sum;
    }
}
