package com.evaluate.demo.dao;

<<<<<<< HEAD
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StatisticsDao {
    List selectAllStatistics(@Param("before")int before, @Param("after")int after);
=======
import com.evaluate.demo.entity.Statistics;

import java.util.List;

public interface StatisticsDao {
    //查询字符云的所需数据
    List<Statistics> selectWordCloudData();
>>>>>>> origin/master

    int selectAllStatisticsCount();
    List selectStatisticsLike(@Param("select_val")String select_val,@Param("before")int before, @Param("after")int after);
    int selectStatisticsCountLike(@Param("select_val")String select_val);
}
