package com.evaluate.demo.dao;

import com.evaluate.demo.entity.Batch;
import com.evaluate.demo.entity.Target;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TargetDao {

    List<Target> selectTarget();

    List<Target> selectEvaluate();

    List<Target> selectFaTarget();

    List<Target> selectChildrenTarget();
    List<Target> getTreeList();
    List<Target> selectTitle(int tid);

    int updateTarget(Integer tid, String tname, String tweight);

    int deleteTarget(Integer tid);
    int insertTarget(Target target);

    int insertEvaluateTarget(int evaluates_id,int targets_id);


}






