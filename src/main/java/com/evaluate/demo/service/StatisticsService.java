package com.evaluate.demo.service;

<<<<<<< HEAD


import java.util.List;
import java.util.Map;

public interface StatisticsService {
    List selectAllStatistics(int before, int after);
    int selectAllStatisticsCount();
    List selectStatisticsLike(String select_val,int before, int after);
    int selectStatisticsCountLike(String select_val);
=======
import com.evaluate.demo.entity.Statistics;

import java.util.List;

public interface StatisticsService {
    //查询字符云的所需数据
    List<Statistics> selectWordCloudData();
>>>>>>> origin/master

}
