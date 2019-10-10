package com.evaluate.demo.service.Impl;

import com.evaluate.demo.dao.PeerReviewDao;

import com.evaluate.demo.entity.User;
import com.evaluate.demo.service.PeerRevicwService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PeerReviewServiceImpl implements PeerRevicwService {
    @Autowired
    private PeerReviewDao peerReviewDao;

    @Override
    public List<User> selectAllPeer(int uid, int before, int after) {
        return peerReviewDao.selectAllPeer(uid, before, after);
    }

    @Override
    public int countPeer(int uid) {
        return peerReviewDao.countPeer(uid);
    }
}
