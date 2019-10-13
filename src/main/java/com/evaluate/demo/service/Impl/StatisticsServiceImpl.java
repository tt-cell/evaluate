package com.evaluate.demo.service.Impl;

import com.evaluate.demo.dao.StatisticsDao;

import com.evaluate.demo.entity.Avg;
import com.evaluate.demo.entity.EvaluateResult;
import com.evaluate.demo.entity.Statistics;
import com.evaluate.demo.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    private StatisticsDao statisticsDao;

    @Override
    public List<EvaluateResult> selectAllStatistics(int batch_id) {
        return statisticsDao.selectAllStatistics(batch_id);
    }

    @Override
    public List<Avg> selectStudentScore(int batch_id, String teacherName) {
        return statisticsDao.selectStudentScore(batch_id,teacherName);
    }

    @Override
    public List<Avg> selectSelfScore(int batch_id, String teacherName) {
        return statisticsDao.selectSelfScore(batch_id,teacherName);
    }

    @Override
    public List<Avg> selectPeerScore(int batch_id, String teacherName) {
        return statisticsDao.selectPeerScore(batch_id,teacherName);
    }

    @Override
    public List<Avg> selectLeaderScore(int batch_id, String teacherName) {
        return statisticsDao.selectLeaderScore(batch_id,teacherName);
    }

    @Override
    public int insertStatistics(Statistics statistics) {
        return statisticsDao.insertStatistics(statistics);
    }

//    @Override
//    public List selectAllStatistics(int before, int after) {
//        return statisticsDao.selectAllStatistics(before, after);
//    }
//
//    @Override
//    public int selectAllStatisticsCount() {
//        return statisticsDao.selectAllStatisticsCount();
//    }
//
//    @Override
//    public List selectStatisticsLike(String select_val, int before, int after) {
//        return statisticsDao.selectStatisticsLike(select_val, before, after);
//    }
//
//    @Override
//    public int selectStatisticsCountLike(String select_val) {
//        return statisticsDao.selectStatisticsCountLike(select_val);
//    }




}
