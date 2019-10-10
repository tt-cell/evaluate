package com.evaluate.demo.dao;

import com.evaluate.demo.entity.EvaluateResult;

public interface EvaluateResultDao {
    //计算一次分数
    int insertEvaluateResult(EvaluateResult evaluateResult);
}
