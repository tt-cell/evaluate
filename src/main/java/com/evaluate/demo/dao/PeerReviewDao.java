package com.evaluate.demo.dao;

import com.evaluate.demo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PeerReviewDao {
    List<User> selectAllPeer(@Param("uid") int uid, @Param("before") int before, @Param("after") int after);
    int countPeer(@Param("uid")int uid);
}
