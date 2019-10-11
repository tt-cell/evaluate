package com.evaluate.demo.service.Impl;

import com.evaluate.demo.dao.PeerDao;

import com.evaluate.demo.service.PeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PeerServiceImpl implements PeerService {
    @Autowired
    private PeerDao peerReviewDao;


    @Override
    public List<Map<String, Object>> selectAllPeer(int uid, String bname) {
        return peerReviewDao.selectAllPeer(uid,bname);
    }
}
