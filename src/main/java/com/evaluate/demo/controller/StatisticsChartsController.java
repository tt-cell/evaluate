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
public class StatisticsChartsController {
    @Autowired
    private StatisticsChartsService statisticsService;
    //跳转到图表数据图
    @RequestMapping("/getevaluateCharts")
    public ModelAndView getevaluateCharts(){
        return new ModelAndView("statisticsChartsManagement");
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
            TangleData.add(statisticsList.get(i).getTeacherName()  + "," + statisticsList.get(i).getStudent_sum()
                    + "," + statisticsList.get(i).getSelf_sum() + "," + statisticsList.get(i).getPeer_sum());
        }
        LinkedList<Object> a =new LinkedList<>();
        a.add(TangleData);
        msg.setMsg("获取数据成功");
        msg.setCode(0);
        msg.setData(a);
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
            map.put("name",statisticsList.get(i).getTeacherName());
            map.put("value",statisticsList.get(i).getScore());
            WordCloudData.add(map);
        }
        msg.setMsg("获取数据成功");
        msg.setCode(0);
        msg.setData(WordCloudData);
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
            LineDataName.add(statisticsList.get(i).getTeacherName());
        }
        for(int j = 0;j<statisticsList.size();j++){
            StudentScoreData.add(statisticsList.get(j).getPeer_sum());
        }
        for(int k = 0;k<statisticsList.size();k++){
            SelfScoreData.add(statisticsList.get(k).getSelf_sum());
        }
        for(int l = 0;l<statisticsList.size();l++){
            PeerScoreData.add(statisticsList.get(l).getPeer_sum());
        }
//        for(int m = 0;m<statisticsList.size();m++){
//            LeaderScoreData.add(Integer.parseInt(statisticsList.get(m).getLeader_score()));
//        }
        LinkedList<Object> rs = new LinkedList<>();
        rs.add(LineDataName);
        rs.add(StudentScoreData);
        rs.add(SelfScoreData);
        rs.add(PeerScoreData);
        //rs.add(LeaderScoreData);
        msg.setMsg("获取成功");
        msg.setCode(0);
        msg.setData(rs);
        return msg;
    }

    //获取水球图数据
    @RequestMapping("/getliquidFillData")
    @ResponseBody
    public Msg getliquidFillData(Msg msg){
        List<Statistics> statisticsList = statisticsService.selectliquidFillData();
        LinkedList<Object> teacherScore = new LinkedList();
        if(statisticsList.size()<0){
            msg.setMsg("");
            msg.setData("失败哦");
            msg.setCode(1);
            return msg;
        }
        for(int i = 0;i<statisticsList.size();i++){
            teacherScore.add(statisticsList.get(i).getScore()/300);
        }
        LinkedList<Object> rs = new LinkedList();
        rs.add(teacherScore);
        msg.setMsg("获取成功");
        msg.setCode(0);
        msg.setData(rs);
        return msg;
    }


}
