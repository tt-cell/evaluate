package com.evaluate.demo.service;


import com.evaluate.demo.entity.Avg;
import com.evaluate.demo.entity.EvaluateResult;
import com.evaluate.demo.entity.Statistics;

import java.util.List;
import java.util.Map;

public interface StatisticsService {
//    List selectAllStatistics(int before, int after);
//    int selectAllStatisticsCount();
//    List selectStatisticsLike(String select_val, int before, int after);
//    int selectStatisticsCountLike(String select_val);


    List<EvaluateResult> selectAllStatistics(int batch_id);

    //各种评教的平均分
    List<Avg> selectStudentScore(int batch_id, String teacherName);
    List<Avg> selectSelfScore(int batch_id,String teacherName);
    List<Avg> selectPeerScore(int batch_id,String teacherName);
    List<Avg> selectLeaderScore(int batch_id,String teacherName);

    //插入一条统计数据
    int insertStatistics(Statistics statistics);


}
