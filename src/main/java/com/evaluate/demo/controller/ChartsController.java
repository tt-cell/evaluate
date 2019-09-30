package com.evaluate.demo.controller;

import com.evaluate.demo.entity.Msg;
import com.evaluate.demo.entity.Statistics;
import com.evaluate.demo.service.StatisticsChartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class ChartsController {
    @Autowired
    private StatisticsChartsService statisticsService;
    //跳转到图表数据图
    @RequestMapping("/getevaluateCharts")
    public ModelAndView getevaluateCharts(){
        return new ModelAndView("evaluateCharts");
    }

    //获得柱状图数据
    @RequestMapping("/getTangleData")
    @ResponseBody
    public Msg getTangleData(Msg msg){
        List<Statistics> statisticsList = statisticsService.selectTangleData();
        LinkedList<Object> TangleData = new LinkedList<>();
        if(statisticsList.size()<0){
            msg.setMsg("");
            msg.setData("获取数据失败");
            msg.setCode(1);
            return msg;
        }
        for(int i = 0;i<statisticsList.size();i++){
            TangleData.add(statisticsList.get(i).getUname()  + "," + statisticsList.get(i).getStudent_score()
                    + "," + statisticsList.get(i).getSelf_score() + "," + statisticsList.get(i).getPeer_score() + "," + statisticsList.get(i).getLeader_score());
        }
        LinkedList<Object> a =new LinkedList<>();
        a.add(TangleData);
        msg.setMsg("获取数据成功");
        msg.setCode(0);
        msg.setData(a);
        return msg;
    }

    //获取折线图数据
    @RequestMapping("/getLineData")
    @ResponseBody
    public Msg getLineData(Msg msg){
        List<Statistics> statisticsList = statisticsService.selectTangleData();
        LinkedList<Object> LineDataName = new LinkedList<>();
        LinkedList<Object> StudentScoreData = new LinkedList<>();
        LinkedList<Object> SelfScoreData = new LinkedList<>();
        LinkedList<Object> PeerScoreData = new LinkedList<>();
        LinkedList<Object> LeaderScoreData = new LinkedList<>();
        if(statisticsList.size()<0){
            msg.setMsg("");
            msg.setData("失败");
            msg.setCode(1);
            return msg;
        }
        for(int i = 0;i<statisticsList.size();i++){
            LineDataName.add(statisticsList.get(i).getUname());
        }
        for(int j = 0;j<statisticsList.size();j++){
            StudentScoreData.add(Integer.parseInt(statisticsList.get(j).getStudent_score()));
        }
        for(int k = 0;k<statisticsList.size();k++){
            SelfScoreData.add(Integer.parseInt(statisticsList.get(k).getSelf_score()));
        }
        for(int l = 0;l<statisticsList.size();l++){
            PeerScoreData.add(Integer.parseInt(statisticsList.get(l).getPeer_score()));
        }
        for(int m = 0;m<statisticsList.size();m++){
            LeaderScoreData.add(Integer.parseInt(statisticsList.get(m).getLeader_score()));
        }
        LinkedList<Object> rs = new LinkedList<>();
        rs.add(LineDataName);
        rs.add(StudentScoreData);
        rs.add(SelfScoreData);
        rs.add(PeerScoreData);
        rs.add(LeaderScoreData);
        msg.setMsg("获取成功");
        msg.setCode(0);
        msg.setData(rs);
        return msg;
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
            map.put("value",Integer.parseInt(statisticsList.get(i).getScore()));
            WordCloudData.add(map);
        }
        msg.setMsg("获取数据成功");
        msg.setCode(0);
        msg.setData(WordCloudData);
        return msg;
    }
}
