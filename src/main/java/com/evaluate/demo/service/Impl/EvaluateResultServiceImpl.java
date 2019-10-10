package com.evaluate.demo.service.Impl;

import com.evaluate.demo.dao.EvaluateResultDao;
import com.evaluate.demo.entity.EvaluateResult;
import com.evaluate.demo.service.EvaluateResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluateResultServiceImpl implements EvaluateResultService {
    @Autowired
    private EvaluateResultDao evaluateResultDao;

    @Override
    public int insertEvaluateResult(EvaluateResult evaluateResult) {
        return evaluateResultDao.insertEvaluateResult(evaluateResult);
    }
}
