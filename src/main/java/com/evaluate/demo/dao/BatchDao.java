package com.evaluate.demo.dao;

import com.evaluate.demo.entity.Batch;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BatchDao {
    List<Batch> selectBatch();
    List<Batch> selectBatch_status(@Param("bid") int bid);

    int updateBatch(int batch_id, int batch_status);
}






