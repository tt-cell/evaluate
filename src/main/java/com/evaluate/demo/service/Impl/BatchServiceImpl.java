package com.evaluate.demo.service.Impl;

import com.evaluate.demo.dao.BatchDao;
import com.evaluate.demo.entity.Batch;
import com.evaluate.demo.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchServiceImpl implements BatchService {
    @Autowired
    private BatchDao batchDao;

    @Override
    public List<Batch> selectBatch() {
        return batchDao.selectBatch();
    }

    @Override
    public List<Batch> selectBatch_status(int bid) {
        return batchDao.selectBatch_status(bid);
    }

    @Override
    public int updateBatch(int batch_id, int batch_status) {
        return batchDao.updateBatch(batch_id,batch_status);
    }
}
