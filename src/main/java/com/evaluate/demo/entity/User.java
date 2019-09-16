package com.evaluate.demo.entity;

public class User {
    private String uid;
    private String uname;
    private String password;
    private String sex;
    private String colleges_id;
    private String list;

    public String getId() {
        return uid;
    }

    public void setId(String uid) {
        this.uid = uid;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getColleges_id() {
        return colleges_id;
    }

    public void setColleges_id(String colleges_id) {
        this.colleges_id = colleges_id;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public String getName() {
        return uname;
    }

    public void setName(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
