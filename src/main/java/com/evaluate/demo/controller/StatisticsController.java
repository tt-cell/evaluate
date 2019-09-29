package com.evaluate.demo.controller;

import com.evaluate.demo.entity.Classs;
import com.evaluate.demo.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
public class StatisticsController {
    @Autowired
    private StatisticsService statisticsService;

    /*返回统计管理页面*/
    @RequestMapping("/getStatisticsManagememt")
    @ResponseBody
    public ModelAndView getStatisticesManagememt(){
        ModelAndView modelAndView = new ModelAndView("statisticsManagement");
        return modelAndView;
    }

    //返回一个统计记录的数据
    @RequestMapping("/getAllStatistics")
    @ResponseBody
    public Map getStatistics (int page,int limit){
        int before = limit * (page - 1);
        int after = limit;
        Map<String,Object> map = new HashMap<>();
        List list = statisticsService.selectAllStatistics(before,after);
        map.put("code",0);
        map.put("data",list);
        map.put("msg","");
        map.put("count", statisticsService.selectAllStatisticsCount());
        return map;
    }
    //返回一个模糊查询的统计记录的数据
    @RequestMapping("/getStatisticsLike")
    @ResponseBody
    public Map getStatisticsLike (String select_val,int page,int limit){
        int before = limit * (page - 1);
        int after = limit;
        Map<String,Object> map = new HashMap<>();
        List list1 = statisticsService.selectStatisticsLike(select_val,before,after);
        map.put("data",list1);
        map.put("code",0);
        map.put("msg","");
        map.put("count",statisticsService.selectStatisticsCountLike(select_val));
        return map;

    }
}
