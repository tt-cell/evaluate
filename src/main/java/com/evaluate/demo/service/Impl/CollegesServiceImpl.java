package com.evaluate.demo.service.Impl;

import com.evaluate.demo.dao.CollegesDao;
import com.evaluate.demo.entity.Colleges;
import com.evaluate.demo.service.CollegesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CollegesServiceImpl implements CollegesService {
    @Autowired
    private CollegesDao collegesDao;

    //通过分页查询学院，班级，用户信息
    @Override
    public List<Map<String, Object>> selectAllColleges(int before, int after) {
        return collegesDao.selectAllColleges(before,after);
    }
    @Override
    public int count() {
        return collegesDao.count();
    }

    @Override
    public int insertColleges(Colleges colleges) {
        return collegesDao.insertColleges(colleges);
    }

}
