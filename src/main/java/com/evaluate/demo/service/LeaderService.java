package com.evaluate.demo.service;


import java.util.List;
import java.util.Map;

public interface LeaderService {
    List<Map<String,Object>> selectLeaderTeacher(int uid, String batch_name);
}
