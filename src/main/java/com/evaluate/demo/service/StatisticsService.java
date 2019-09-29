package com.evaluate.demo.service;


import java.util.List;
import java.util.Map;

public interface StatisticsService {
    List selectAllStatistics(int before, int after);
    int selectAllStatisticsCount();
    List selectStatisticsLike(String select_val, int before, int after);
    int selectStatisticsCountLike(String select_val);


}
