package com.evaluate.demo.service;



import com.evaluate.demo.entity.Statistics;

import java.util.List;

public interface StatisticsChartsService {
    //查询字符云的所需数据
    List<Statistics> selectWordCloudData();


}
