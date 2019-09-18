package com.evaluate.demo.entity;

import java.util.ArrayList;

public class User {
    private String uid;
    private String uname;
    private String password;
    private int sex;
    private int colleges_id;
    private ArrayList<User> list;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }


    public ArrayList<User> getList() {
        return list;
    }

    public int getColleges_id() {
        return colleges_id;
    }

    public void setColleges_id(int colleges_id) {
        this.colleges_id = colleges_id;
    }

    public void setList(ArrayList<User> list) {
        this.list = list;
    }
}
