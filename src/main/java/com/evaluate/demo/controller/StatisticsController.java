package com.evaluate.demo.controller;

import com.evaluate.demo.entity.Avg;
import com.evaluate.demo.entity.Classs;
import com.evaluate.demo.entity.EvaluateResult;
import com.evaluate.demo.entity.Statistics;
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

    @RequestMapping(value = "/getAllTheTeachersScore")
    @ResponseBody
    public Map getAllTheTeachers(int batch_id){
        Map<String,Object> map = new HashMap<>();
        List<EvaluateResult> evaluateResultList = statisticsService.selectAllStatistics(batch_id);
        Statistics statistics = new Statistics();
        float sum = 0;//总分
        for (int i=0;i<evaluateResultList.size();i++) {
            String teacher = evaluateResultList.get(i).getTeacherName();//获取被评分人姓名
            int batchid = evaluateResultList.get(i).getBatch_id();//获取批次ID
            int tid = evaluateResultList.get(i).getTid();//获取被评分人ID
            List<Avg> studentRs = statisticsService.selectStudentScore(batch_id,teacher);//获取被评分人的学生平均分
            List<Avg> selfRs = statisticsService.selectSelfScore(batch_id,teacher);//获取被评分人的自评平均分
            List<Avg> peerRs = statisticsService.selectPeerScore(batch_id,teacher);//获取被评分人的同行平均分
            List<Avg> leaderRs = statisticsService.selectLeaderScore(batch_id,teacher);//获取被评分人的领导平均分
            float studentScore = studentRs.get(0).getPjf();//得到学生的平均分
            float selfScore = selfRs.get(0).getPjf();//得到自评的平均分
            float peerScore = peerRs.get(0).getPjf();//得到同行平均分
            float leaderScore = leaderRs.get(0).getPjf();
            sum = selfScore+studentScore+peerScore+leaderScore;//得到四个类型的总分或
            statistics.setBatch_id(batchid);
            statistics.setUid(tid);
            statistics.setTeacherName(teacher);
            statistics.setStudent_sum(studentScore);
            statistics.setSelf_sum(selfScore);
            statistics.setPeer_sum(peerScore);
            statistics.setLeader_sum(leaderScore);

            statistics.setScore(sum);
            int result = statisticsService.insertStatistics(statistics);
            if (result>0){
                map.put("data",1);
            }else {
                map.put("data",0);
            }
//
        }

        return map;
    }

}
