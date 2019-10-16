package com.evaluate.demo.dao;

import com.evaluate.demo.entity.Classs;
import com.evaluate.demo.entity.ClasssCourses;
import com.evaluate.demo.entity.Colleges;
import com.evaluate.demo.entity.Course;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface CourseDao {
    //分页查询所有的课程列表
     List<Map<String,Object>> selectAllCourse(int before, int after);
     int count();

     //删除一门课程
    int deleteOneCourse(int courses_id);

    //修改一门课程
    int updateOneCourse(Course course);

    //搜索一门课程名称
    List<Map<String,Object>> searchCourseName(@Param("courses_name") String courses_name);

    //添加一门课程、班级
    int insertCourse(Course course);
    int insertCourseClasss(ClasssCourses classsCourses);
    int insertClasss(Classs classs);

    //搜索班级，以及每个班级下面对应的课程
    List<Classs> selectAllClasss();
    List<Course> selectClasssCourse();

    //搜索学院，以及学院下面对应的班级
    List<Colleges> selectAllTheColleges();
    List<Classs> selectCollegesClasss(int colleges_id);
}
