package com.evaluate.demo.service;
import com.evaluate.demo.entity.Target;

import java.util.List;
import java.util.Map;

public interface TargetService {
    List<Target> selectTarget();
    List<Target> selectEvaluate();
    List<Target> selectFaTarget();
    List<Target> selectChildrenTarget();
    List<Map<String, Object>> getTreeList();
    List<Target> selectTitle(int tid);
    int updateTarget(Integer tid, String tname, String tweight);

    int deleteTarget(Integer tid);
    int insertTarget(Target target);
    int insertEvaluateTarget(int evaluates_id,int targets_id);
}
