package com.evaluate.demo.service;


import com.evaluate.demo.entity.Option;
import com.evaluate.demo.entity.Target;

import java.util.List;
import java.util.Map;


public interface TeacherService {
    List<Map<String, Object>> selectTeachers(int uid, String bname);
    List<Target> getTweight(int targets_id);
    List<Option> getOweight(String options_name);
}
