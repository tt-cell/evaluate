package com.evaluate.demo.service;

import com.evaluate.demo.entity.User;

import java.util.List;

public interface PeerRevicwService {
    List<User> selectAllPeer(int uid,int before,int after);
    int countPeer(int uid);
}
