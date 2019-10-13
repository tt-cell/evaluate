package com.evaluate.demo.service;

import com.evaluate.demo.entity.Statistics;

import java.util.List;

public interface StatisticsTableService {
    List<Statistics> selectAllStatistics(int before, int after);
    int selectAllStatisticsCount();

    List selectStatisticsLike(String select_val);
    int selectStatisticsCountLike(String select_val);
}
