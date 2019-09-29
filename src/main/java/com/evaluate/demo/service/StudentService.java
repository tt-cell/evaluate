package com.evaluate.demo.service;


import java.util.List;
import java.util.Map;


public interface StudentService {
    List<Map<String, Object>> selectTeacher(int uid, String bname);
}
