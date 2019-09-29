package com.evaluate.demo.dao;

import com.evaluate.demo.entity.Statistics;

import java.util.List;

public interface StatisticsChartsDao {

    //查询字符云的所需数据
    List<Statistics> selectWordCloudData();
}
