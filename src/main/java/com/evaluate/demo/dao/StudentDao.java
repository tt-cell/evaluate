package com.evaluate.demo.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StudentDao {
    List<Map<String, Object>> selectTeacher(int uid, String bname);

}






