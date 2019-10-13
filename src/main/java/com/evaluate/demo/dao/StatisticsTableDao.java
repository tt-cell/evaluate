package com.evaluate.demo.dao;

import com.evaluate.demo.entity.Statistics;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StatisticsTableDao {
    List<Statistics> selectAllStatistics(int before,int after);
    int selectAllStatisticsCount();

    List<Statistics> selectStatisticsLike(@Param("select_val") String select_val);
    int selectStatisticsCountLike(@Param("select_val") String select_val);
}
