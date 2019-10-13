package com.evaluate.demo.service.Impl;

import com.evaluate.demo.dao.StatisticsTableDao;
import com.evaluate.demo.entity.Statistics;
import com.evaluate.demo.service.StatisticsTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsTableServiceImpl implements StatisticsTableService {
    @Autowired
    private StatisticsTableDao statisticsTableDao;


    @Override
    public List<Statistics> selectAllStatistics(int before, int after) {
        return statisticsTableDao.selectAllStatistics(before,after);
    }

    @Override
    public int selectAllStatisticsCount() {
        return statisticsTableDao.selectAllStatisticsCount();
    }

    @Override
    public List selectStatisticsLike(String select_val) {
        return statisticsTableDao.selectStatisticsLike(select_val);
    }

    @Override
    public int selectStatisticsCountLike(String select_val) {
        return statisticsTableDao.selectStatisticsCountLike(select_val);
    }
}
