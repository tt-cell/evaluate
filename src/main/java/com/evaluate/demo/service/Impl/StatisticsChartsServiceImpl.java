package com.evaluate.demo.service.Impl;

import com.evaluate.demo.dao.StatisticsChartsDao;
import com.evaluate.demo.entity.Statistics;
import com.evaluate.demo.service.StatisticsChartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsChartsServiceImpl implements StatisticsChartsService {
    @Autowired
    private StatisticsChartsDao statisticsDao;

    @Override
    public List<Statistics> selectWordCloudData() {
        return statisticsDao.selectWordCloudData();
    }
}
