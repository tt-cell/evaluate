package com.evaluate.demo.controller;

import com.evaluate.demo.entity.Classs;
import com.evaluate.demo.entity.ClasssCourses;
import com.evaluate.demo.entity.Course;
import com.evaluate.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;

    //查询所有课程的信息
    @RequestMapping(value = "/courseManagement")
    @ResponseBody
    public Map getAllTheCourse(int page, int limit) {
        //分页条件
        int before = limit * (page - 1);
        //数据库中查询出来的结果放在courseList里面
        List<Map<String, Object>> courseList = courseService.selectAllCourse(before, limit);
        int count = courseService.count();
        //键值对封装对象
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("code", 0);
        map.put("msg", "获取数据成功");
        map.put("count", count);
        map.put("data", courseList);
        return map;
    }

    @RequestMapping(value = "/getCourseManagement")
    public ModelAndView goCourseList() {
        return new ModelAndView("courseManagement");
    }


    //删除一门课程的信息
    @RequestMapping(value = "/deleteOneCourse")
    @ResponseBody
    public boolean deleteOneCourse(int courses_id) {
        boolean rs = courseService.deleteOneCourse(courses_id);
        if (rs)
            return true;
        else
            return false;
    }


    //修改一门课程的信息
    @RequestMapping(value = "/updateOneCourse")
    @ResponseBody
    public int updateOneCourse(Course course) {
        int rs = courseService.updateOneCourse(course);
        if (rs > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    //搜索一门课程名称
    @RequestMapping(value = "/searchOneCourse")
    @ResponseBody
    public Map searchOneCourse(String courses_name){
        List<Map<String,Object>> courseList = courseService.searchCourseName(courses_name);
        int count = courseService.count();
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("code", 0);
        map.put("msg", "获取数据成功");
        map.put("count", count);
        map.put("data", courseList);
        return map;
    }

    //添加一门课程、班级
    @RequestMapping("/insertCourses")
    @ResponseBody
    public int insertCourses(Course course) {
        int coursesRs = courseService.insertCourse(course);
        if(coursesRs>0)
            return coursesRs;
        else
            return 0;
    }
    @RequestMapping("/insertCoursesClasss")
    @ResponseBody
    public int insertCoursesClasss(ClasssCourses classsCourses) {
        int classsCoursesRs = courseService.insertCourseClasss(classsCourses);
        if(classsCoursesRs>0)
            return classsCoursesRs;
        else
            return 0;
    }
    @RequestMapping("/insertClasss")
    @ResponseBody
    public int insertClasss(Classs classs) {
        int classsRs = courseService.insertClasss(classs);
        if(classsRs>0)
            return classsRs;
        else
            return 0;
    }
    @RequestMapping("/AddCourse")
    public ModelAndView goAddCourse(){
        return new ModelAndView("insertCourse");
    }

    @RequestMapping("/insertClasssCourse")
    public ModelAndView insertClasssCourse(){
        return new ModelAndView("insertCoursesClasss");
    }

    //搜索班级，以及每个班级下面对应的课程
    @RequestMapping("/selectAllTheClasss")
    @ResponseBody
    public Map selectAllClasss(){
        List<Classs> classsList = courseService.selectAllClasss();
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","获取数据成功");
        map.put("data",classsList);
        return map;
    }

    @RequestMapping("/selectClasssCourse")
    @ResponseBody
    public Map selectClasssCourse(int classs_id){
        List<Course> classsCoursesList = courseService.selectClasssCourse(classs_id);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","获取数据成功");
        map.put("data",classsCoursesList);
        return map;
    }

}
