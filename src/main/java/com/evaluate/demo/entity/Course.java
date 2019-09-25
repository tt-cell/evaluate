package com.evaluate.demo.entity;

public class Course {
    private int courses_id;
    private String courses_name;
    private String school_year;
    private int classs_id;

    public int getCourses_id() {
        return courses_id;
    }

    public void setCourses_id(int courses_id) {
        this.courses_id = courses_id;
    }

    public String getCourses_name() {
        return courses_name;
    }

    public void setCourses_name(String courses_name) {
        this.courses_name = courses_name;
    }

    public String getSchool_year() {
        return school_year;
    }

    public void setSchool_year(String school_year) {
        this.school_year = school_year;
    }

    public int getClasss_id() {
        return classs_id;
    }

    public void setClasss_id(int classs_id) {
        this.classs_id = classs_id;
    }
}
