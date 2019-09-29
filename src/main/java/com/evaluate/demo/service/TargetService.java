package com.evaluate.demo.service;
import com.evaluate.demo.entity.Target;

import java.util.List;
import java.util.Map;

public interface TargetService {
    List<Target> selectTarget();

    List<Map<String, Object>> getTreeList();
    List<Target> selectTitle(int tid);
    int updateTarget(Integer tid, String tname, String tweight);

    int deleteTarget(Integer tid);

}
