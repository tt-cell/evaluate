package com.evaluate.demo.service.Impl;



import com.evaluate.demo.dao.TeacherDao;

import com.evaluate.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;


    @Override
    public List<Map<String, Object>> selectTeachers(int uid, String bname) {
        return teacherDao.selectTeachers(uid,bname);
    }
}
