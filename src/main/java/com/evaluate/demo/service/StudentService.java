package com.evaluate.demo.service;


import com.evaluate.demo.entity.EvaluateResult;

import java.util.List;
import java.util.Map;


public interface StudentService {
    List<Map<String, Object>> selectTeacher(int uid, String bname);
    //根据条件查询结果判断是否评教过
    List<EvaluateResult> selectIfEvaluateresult(EvaluateResult evaluateResult);
}
