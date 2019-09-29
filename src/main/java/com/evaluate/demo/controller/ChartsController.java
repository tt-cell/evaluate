package com.evaluate.demo.controller;

import com.evaluate.demo.entity.Msg;
import com.evaluate.demo.entity.Statistics;
import com.evaluate.demo.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class ChartsController {
    @Autowired
    private StatisticsService statisticsService;
    //跳转到图表数据图
    @RequestMapping("/getevaluateCharts")
    public ModelAndView getevaluateCharts(){
        return new ModelAndView("evaluateCharts");
    }

    //获取字符云数据
    @RequestMapping("/getWordCloudData")
    @ResponseBody
    public Msg getWordCloudData(Msg msg){
        List<Statistics> statisticsList = statisticsService.selectWordCloudData();
        List WordCloudData = new ArrayList();
        if(statisticsList.size()<0){
            msg.setMsg("");
            msg.setData("");
            msg.setCode(1);
            return msg;
        }
        for(int i = 0;i<statisticsList.size();i++){
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("name",statisticsList.get(i).getUname());
            map.put("value",statisticsList.get(i).getScore());
            WordCloudData.add(map);
        }
        msg.setMsg("获取数据成功");
        msg.setCode(0);
        msg.setData(WordCloudData);
        return msg;
    }
}
