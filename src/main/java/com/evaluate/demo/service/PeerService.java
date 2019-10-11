package com.evaluate.demo.service;


import java.util.List;
import java.util.Map;

public interface PeerService {
    List<Map<String,Object>> selectAllPeer(int uid,String batch_name);
    //    int countPeer(int uid);
}
