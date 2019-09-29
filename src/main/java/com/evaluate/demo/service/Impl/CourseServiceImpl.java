package com.evaluate.demo.service.Impl;


import com.evaluate.demo.dao.CourseDao;
import com.evaluate.demo.entity.Classs;
import com.evaluate.demo.entity.ClasssCourses;
import com.evaluate.demo.entity.Colleges;
import com.evaluate.demo.entity.Course;
import com.evaluate.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;


    //查询数据
    @Override
    public List<Map<String,Object>> selectAllCourse(int before, int after) {
        return courseDao.selectAllCourse(before,after);
    }

    //查询所有的条数
    @Override
    public int count() {
        return courseDao.count();
    }

    //删除一门课程信息
    @Override
    public boolean deleteOneCourse(int courses_id) {
        int rs = courseDao.deleteOneCourse(courses_id);
        if (rs>0){
            return true;
        }else {
            return false;
        }
    }

    //修改一门课程信息
    @Override
    public int updateOneCourse(Course course) {
        return courseDao.updateOneCourse(course);
    }

    //搜索一门课程名称
    @Override
    public  List<Map<String,Object>> searchCourseName(String courses_name) {
        return courseDao.searchCourseName(courses_name);
    }


    //添加一门课程、班级
    @Override
    public int insertCourse(Course course) {
        return courseDao.insertCourse(course);
    }

    @Override
    public int insertCourseClasss(ClasssCourses classsCourses) {
        return courseDao.insertCourseClasss(classsCourses);
    }

    @Override
    public int insertClasss(Classs classs) {
        return courseDao.insertClasss(classs);
    }

    @Override
    public List<Classs> selectAllClasss() {
        return courseDao.selectAllClasss();
    }

    @Override
    public List<Course> selectClasssCourse(int classs_id) {
        return courseDao.selectClasssCourse(classs_id);
    }

    @Override
    public List<Colleges> selectAllTheColleges() {
        return courseDao.selectAllTheColleges();
    }

    @Override
    public List<Classs> selectCollegesClasss(int colleges_id) {
        return courseDao.selectCollegesClasss(colleges_id);
    }
}
