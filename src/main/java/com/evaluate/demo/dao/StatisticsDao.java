package com.evaluate.demo.dao;


import com.evaluate.demo.entity.Avg;
import com.evaluate.demo.entity.EvaluateResult;
import com.evaluate.demo.entity.Statistics;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StatisticsDao {

    //获取所有老师
    List<EvaluateResult> selectAllStatistics(int batch_id);

    //各种评教的平均分
    List<Avg> selectStudentScore(int batch_id, String teacherName);
    List<Avg> selectSelfScore(int batch_id,String teacherName);
    List<Avg> selectPeerScore(int batch_id,String teacherName);
    List<Avg> selectLeaderScore(int batch_id,String teacherName);

    //插入一条统计数据
    int insertStatistics(Statistics statistics);
}
