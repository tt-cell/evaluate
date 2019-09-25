package com.evaluate.demo.controller;

import com.evaluate.demo.entity.Colleges;
import com.evaluate.demo.entity.Course;
import com.evaluate.demo.service.CollegesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CollegesController {
    @Autowired
    private CollegesService collegesService;

    //通过分页查询学院，班级，用户信息
    @RequestMapping("/collegesManagement")
    @ResponseBody
    public Map getAllColleges(int page, int limit) {
        int before = limit * (page - 1);
        int after = page * limit;
        List<Map<String, Object>> collegeList = collegesService.selectAllColleges(before, after);
        int count = collegesService.count();
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("code", 0);
        map.put("msg", "成功获取数据");
        map.put("count", count);
        map.put("data", collegeList);
        return map;
    }

    @RequestMapping(value = "/getCollegesManagement")
    public ModelAndView goCollegesList() {
        return new ModelAndView("collegesManagement");
    }



    //添加一个学院
    @RequestMapping("/insertColleges")
    @ResponseBody
    public int insertCourses(Colleges colleges) {
        int collegesRs = collegesService.insertColleges(colleges);
        if(collegesRs>0)
            return collegesRs;
        else
            return 0;
    }

    @RequestMapping("/AddColleges")
    public ModelAndView goAddCourse(){
        return new ModelAndView("insertColleges");
    }
}
