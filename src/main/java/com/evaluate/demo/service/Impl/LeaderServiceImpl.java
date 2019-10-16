package com.evaluate.demo.service.Impl;


import com.evaluate.demo.dao.LeaderDao;
import com.evaluate.demo.service.LeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LeaderServiceImpl implements LeaderService {
    @Autowired
    private LeaderDao leaderDao;

    @Override
    public List<Map<String, Object>> selectLeaderTeacher(int uid, String batch_name) {
        return leaderDao.selectLeaderTeacher(uid, batch_name);
    }
}
