package com.evaluate.demo.service.Impl;


import com.evaluate.demo.dao.StudentDao;
import com.evaluate.demo.entity.EvaluateResult;
import com.evaluate.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Map<String, Object>> selectTeacher(int uid, String bname) {
        return studentDao.selectTeacher(uid,bname);
    }

    //根据条件查询结果判断是否评教过
    @Override
    public List<EvaluateResult> selectIfEvaluateresult(EvaluateResult evaluateResult) {
        return studentDao.selectIfEvaluateresult(evaluateResult);
    }
}
