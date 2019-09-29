package com.evaluate.demo.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StatisticsDao {
    List selectAllStatistics(@Param("before")int before, @Param("after")int after);

    int selectAllStatisticsCount();
    List selectStatisticsLike(@Param("select_val")String select_val,@Param("before")int before, @Param("after")int after);
    int selectStatisticsCountLike(@Param("select_val")String select_val);
}
