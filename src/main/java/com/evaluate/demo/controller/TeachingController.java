package com.evaluate.demo.controller;

import com.evaluate.demo.entity.Classs;
import com.evaluate.demo.entity.ClasssCourses;
import com.evaluate.demo.entity.Course;
import com.evaluate.demo.entity.UsersTeachCourse;
import com.evaluate.demo.service.CourseService;
import com.evaluate.demo.service.TeachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TeachingController {

    @Autowired
    private TeachingService teachingService;

    //跳转到teachingManagement界面
    @RequestMapping(value = "/getTeachingManagement")
    public ModelAndView goCourseList (){
        return new ModelAndView("teachingManagement");
    }
    //获取所有的教学列表
    @RequestMapping(value = "/teachingManagement")
    @ResponseBody
    public Map getAllTheCourse(int page, int limit){
        //分页条件
        int before = limit * (page - 1) ;
        //数据库中查询出来的结果放在courseList里面
        List<Map<String,Object>> courseList = teachingService.selectAllTeaching(before,limit);
        int count = teachingService.count();
        //键值对封装对象
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("code", 0);
        map.put("msg", "获取数据成功");
        map.put("count", count);
        map.put("data", courseList);
        return map;
    }
    //跳转到insertTeaching界面
    @RequestMapping(value = "/AddTeaching")
    public ModelAndView AddTeaching (){
        return new ModelAndView("insertTeaching");
    }

    //添加一门授课信息
    @RequestMapping("/insertUserTeachCourse")
    @ResponseBody
    public int insertUserTeachCourse(UsersTeachCourse usersTeachCourse) {
        int usersTeachCourseRs = teachingService.insertUserTeachCourse(usersTeachCourse);
        if(usersTeachCourseRs>0)
            return usersTeachCourseRs;
        else
            return 0;
    }

    @RequestMapping("/selectAllClasss")
    @ResponseBody
    public Map selectAllClasss(){
        List<Classs> classsList = teachingService.selectClasss();
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","获取数据成功");
        map.put("data",classsList);
        return map;
    }

    @RequestMapping("/selectAllCourses")
    @ResponseBody
    public Map selectAllCourses(){
        List<Course> courseList = teachingService.selectCourse();
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","获取数据成功");
        map.put("data",courseList);
        return map;
    }

}
