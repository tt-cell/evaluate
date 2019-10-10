package com.evaluate.demo.service;


import java.util.List;
import java.util.Map;


public interface TeacherService {
    List<Map<String, Object>> selectTeachers(int uid, String bname);
}
