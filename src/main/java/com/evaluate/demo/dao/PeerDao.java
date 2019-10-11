package com.evaluate.demo.dao;

import com.evaluate.demo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PeerDao {
    List<Map<String,Object>> selectAllPeer(@Param("uid") int uid, @Param("batch_name") String batch_name);
//    int countPeer(@Param("uid")int uid);
}
