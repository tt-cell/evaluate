package com.evaluate.demo.service.Impl;

import com.evaluate.demo.dao.StatisticsDao;
import com.evaluate.demo.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    private StatisticsDao statisticsDao;
    @Override
    public List selectAllStatistics(int before, int after) {
        return statisticsDao.selectAllStatistics(before, after);
    }

    @Override
    public int selectAllStatisticsCount() {
        return statisticsDao.selectAllStatisticsCount();
    }

    @Override
    public List selectStatisticsLike(String select_val, int before, int after) {
        return statisticsDao.selectStatisticsLike(select_val, before, after);
    }

    @Override
    public int selectStatisticsCountLike(String select_val) {
        return statisticsDao.selectStatisticsCountLike(select_val);
    }


}
