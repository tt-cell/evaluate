package com.evaluate.demo.dao;

import com.evaluate.demo.entity.Option;
import com.evaluate.demo.entity.Target;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TeacherDao {
    List<Map<String, Object>> selectTeachers(int uid, String bname);
    List<Target> getTweight(int targets_id);
    List<Option> getOweight(String options_name);
}






