package com.evaluate.demo.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface LeaderDao {
    List<Map<String,Object>> selectLeaderTeacher(@Param("uid") int uid, @Param("batch_name") String batch_name);
}
