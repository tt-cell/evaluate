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
    private StatisticsChartsDao statisticsChartsDao;


    @Override
    public List<Statistics> selectTangleData() {
        return statisticsChartsDao.selectTangleData();
    }

    @Override
    public List<Statistics> selectWordCloudData() {
        return statisticsChartsDao.selectWordCloudData();
    }

    @Override
    public List<Statistics> selectLineData() {
        return statisticsChartsDao.selectLineData();
    }

    @Override
    public List<Statistics> selectliquidFillData() {
        return statisticsChartsDao.selectliquidFillData();
    }
}
