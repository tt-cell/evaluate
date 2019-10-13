package com.evaluate.demo.controller;

import com.evaluate.demo.entity.Statistics;
import com.evaluate.demo.service.StatisticsTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StatisticsTableController {
    @Autowired
    private StatisticsTableService statisticsTableService;

        /*返回统计管理页面*/
    @RequestMapping("/getStatisticsManagement")
    @ResponseBody
    public ModelAndView getStatisticesManagememt(){
        ModelAndView modelAndView = new ModelAndView("statisticsTableManagement");
        return modelAndView;
    }

    //返回一个统计记录的数据
    @RequestMapping("/getAllStatisticsTableData")
    @ResponseBody
    public Map getStatistics (int page, int limit){
        int before = limit * (page - 1);
        int after = limit;
        Map<String,Object> map = new HashMap<>();
        List<Statistics> list = statisticsTableService.selectAllStatistics(before,after);
        map.put("code",0);
        map.put("data",list);
        map.put("msg","");
        map.put("count", statisticsTableService.selectAllStatisticsCount());
        return map;
    }
    //返回一个模糊查询的统计记录的数据
    @RequestMapping("/getStatisticsTableLike")
    @ResponseBody
    public Map getStatisticsLike (String select_val){
        Map<String,Object> map = new HashMap<>();
        List list1 = statisticsTableService.selectStatisticsLike(select_val);
        map.put("data",list1);
        map.put("code",0);
        map.put("msg","");
        map.put("count",statisticsTableService.selectStatisticsCountLike(select_val));
        return map;

    }
}
