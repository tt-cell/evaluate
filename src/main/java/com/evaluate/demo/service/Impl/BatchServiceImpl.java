package com.evaluate.demo.service.Impl;

import com.evaluate.demo.dao.BatchDao;
import com.evaluate.demo.entity.Batch;
import com.evaluate.demo.entity.UserBatch;
import com.evaluate.demo.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchServiceImpl implements BatchService {
    @Autowired
    private BatchDao batchDao;

    @Override
    public List<Batch> selectAllTheBatch() {
        return batchDao.selectAllTheBatch();
    }

    @Override
    public List<Batch> selectBatchByPage(int before,int after) {
        return batchDao.selectBatchByPage(before,after);
    }

    @Override
    public int count() {
        return batchDao.count();
    }

    @Override
    public List<Batch> selectBatch_status(int bid) {
        return batchDao.selectBatch_status(bid);
    }

    @Override
    public int updateBatch(int batch_id, int batch_status) {
        return batchDao.updateBatch(batch_id,batch_status);
    }

    @Override
    public int updateName(int batch_id, String batch_name) {
        return batchDao.updateName(batch_id,batch_name);
    }

    @Override
    public int deleteBatch(int batch_id) {
        return batchDao.deleteBatch(batch_id);
    }

    @Override
    public int insertBatch(Batch batch) {
        return batchDao.insertBatch(batch);
    }

    @Override
    public int insertUserBatch(int uid, int batch_id) {
        return batchDao.insertUserBatch(uid,batch_id);
    }

    @Override
    public List<UserBatch> selectAllTheUserBatch() {
        return batchDao.selectAllTheUserBatch();
    }
}
