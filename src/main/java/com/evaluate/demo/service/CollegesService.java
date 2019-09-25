package com.evaluate.demo.service;

import com.evaluate.demo.entity.Colleges;

import java.util.List;
import java.util.Map;

public interface CollegesService {
    //通过分页查询学院，班级，用户信息
    List<Map<String,Object>> selectAllColleges(int before, int after);
    int count();

    //添加一个学院
    int insertColleges(Colleges colleges);

}
