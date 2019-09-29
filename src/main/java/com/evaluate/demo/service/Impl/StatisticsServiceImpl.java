package com.evaluate.demo.service.Impl;

import com.evaluate.demo.dao.StatisticsDao;
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
    public List<Statistics> selectWordCloudData() {
        return statisticsDao.selectWordCloudData();
    }
}
