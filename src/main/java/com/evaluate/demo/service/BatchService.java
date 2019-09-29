package com.evaluate.demo.service;

import com.evaluate.demo.entity.Batch;

import java.util.List;

public interface BatchService {
    List<Batch> selectBatch();
    List<Batch> selectBatch_status(int bid);
    int updateBatch(int batch_id, int batch_status);
}
