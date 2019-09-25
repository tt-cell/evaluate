package com.evaluate.demo.service;

import com.evaluate.demo.entity.Classs;
import com.evaluate.demo.entity.ClasssCourses;
import com.evaluate.demo.entity.Course;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface CourseService {
    //分页查询所有的课程列表
     List<Map<String,Object>> selectAllCourse(int before, int after);
     int count();

    //删除一门课程
    boolean deleteOneCourse(int courses_id);

    //修改一门课程
    int updateOneCourse(Course course);

    //搜索一门课程名称
    List<Map<String,Object>> searchCourseName(String courses_name);

    //添加一门课程、班级
    int insertCourse(Course course);
    int insertCourseClasss(ClasssCourses classsCourses);
    int insertClasss(Classs classs);


    //搜索班级，以及每个班级下面对应的课程
    List<Classs> selectAllClasss();
    List<Course> selectClasssCourse(int classs_id);
}
