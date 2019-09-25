package com.evaluate.demo.service.Impl;

import com.evaluate.demo.dao.TeachingDao;
import com.evaluate.demo.entity.Classs;
import com.evaluate.demo.entity.Course;
import com.evaluate.demo.entity.UsersTeachCourse;
import com.evaluate.demo.service.TeachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TeachingServiceImpl implements TeachingService {
    @Autowired
    private TeachingDao teachingDao;

    @Override
    public List<Map<String, Object>> selectAllTeaching(int before, int after) {
        return teachingDao.selectAllTeaching(before,after);
    }

    @Override
    public int count() {
        return teachingDao.count();
    }

    @Override
    public int insertUserTeachCourse(UsersTeachCourse usersTeachCourse) {
        return teachingDao.insertUserTeachCourse(usersTeachCourse);
    }

    @Override
    public List<Course> selectCourse() {
        return teachingDao.selectCourse();
    }

    @Override
    public List<Classs> selectClasss() {
        return teachingDao.selectClasss();
    }

}
