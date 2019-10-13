package com.evaluate.demo.service;



import com.evaluate.demo.entity.Statistics;

import java.util.List;

public interface StatisticsChartsService {
    //查询柱形图数据
    List<Statistics> selectTangleData();
    //查询字符云的所需数据
    List<Statistics> selectWordCloudData();
    //查询折线图的所需数据
    List<Statistics> selectLineData();
    //查询水球图数据
    List<Statistics> selectliquidFillData();
}
