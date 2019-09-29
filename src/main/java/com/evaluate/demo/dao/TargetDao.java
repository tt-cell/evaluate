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

    List<Target> getTreeList();
    List<Target> selectTitle(int tid);

    int updateTarget(Integer tid, String tname, String tweight);

    int deleteTarget(Integer tid);

}






