package com.evaluate.demo.service;

import com.evaluate.demo.entity.Batch;
import com.evaluate.demo.entity.UserBatch;

import java.util.List;

public interface BatchService {
    List<Batch> selectAllTheBatch();
    List<Batch> selectBatchByPage(int before,int after);
    int count();

    List<Batch> selectBatch_status(int bid);
    int updateBatch(int batch_id, int batch_status);

    int updateName(int batch_id, String batch_name);
    int deleteBatch(int batch_id);
    int insertBatch(Batch batch);
    int insertUserBatch(int uid,int batch_id);
    //获取所有用户所在批次
    List<UserBatch> selectAllTheUserBatch();
}
