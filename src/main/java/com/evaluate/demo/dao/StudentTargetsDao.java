package com.evaluate.demo.dao;

import com.evaluate.demo.entity.Option;
import com.evaluate.demo.entity.Target;

import java.util.List;

public interface StudentTargetsDao {
    //获取学生评教的指标以及选项
    List<Target> selectStudentTargets(int evaluates_id);
    List<Option> selectStudentOptions();
}
