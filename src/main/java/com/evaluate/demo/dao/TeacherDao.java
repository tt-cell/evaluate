package com.evaluate.demo.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TeacherDao {
    List<Map<String, Object>> selectTeachers(int uid, String bname);
}






