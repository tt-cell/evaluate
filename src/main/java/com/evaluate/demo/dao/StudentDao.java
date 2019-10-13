package com.evaluate.demo.dao;

import com.evaluate.demo.entity.EvaluateResult;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StudentDao {
    List<Map<String, Object>> selectTeacher(int uid, String bname);

    //根据条件查询结果判断是否评教过
    List<EvaluateResult> selectIfEvaluateresult(EvaluateResult evaluateResult);

}






