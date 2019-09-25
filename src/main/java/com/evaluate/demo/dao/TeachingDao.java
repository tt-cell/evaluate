package com.evaluate.demo.dao;

import com.evaluate.demo.entity.Classs;
import com.evaluate.demo.entity.Course;
import com.evaluate.demo.entity.UsersTeachCourse;

import java.util.List;
import java.util.Map;

public interface TeachingDao {
    //分页查询所有的授课列表
    List<Map<String,Object>> selectAllTeaching(int before, int after);
    int count();

    //插入授课
    int insertUserTeachCourse(UsersTeachCourse usersTeachCourse);

    //查询班级，课程
    List<Course> selectCourse();
    List<Classs> selectClasss();
}
