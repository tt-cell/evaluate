package com.evaluate.demo.service.Impl;

import com.evaluate.demo.dao.StudentTargetsDao;
import com.evaluate.demo.entity.Option;
import com.evaluate.demo.entity.Target;
import com.evaluate.demo.service.StudentTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentTargetsServiceImpl implements StudentTargetService {
    @Autowired
    private StudentTargetsDao studentTargetsDao;

    @Override
    public List<Target> selectStudentTargets(int evaluates_id) {
        return studentTargetsDao.selectStudentTargets(evaluates_id);
    }

    @Override
    public List<Option> selectStudentOptions() {
        return studentTargetsDao.selectStudentOptions();
    }
}
