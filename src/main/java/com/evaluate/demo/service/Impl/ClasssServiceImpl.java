package com.evaluate.demo.service.Impl;

import com.evaluate.demo.dao.ClasssDao;
import com.evaluate.demo.entity.Classs;
import com.evaluate.demo.entity.User;
import com.evaluate.demo.service.ClasssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasssServiceImpl implements ClasssService {
    @Autowired
    private ClasssDao classsDao;


    @Override
    public List<Classs> selectAllClasss(int before, int after) {
        return classsDao.selectAllClasss(before, after);
    }

    @Override
    public int selectAllClasssCount() {
        return classsDao.selectAllClasssCount();
    }

    @Override
    public List<User> selectUsersByClasss(int classs_id) {
        return classsDao.selectUsersByClasss(classs_id);
    }

    @Override
    public int insertOneClass(String classs_name, String classs_code) {
        return classsDao.insertOneClass(classs_name,classs_code);
    }


    @Override
    public int insertUserByClasss(int classs_id,List<Integer> list) {
        return classsDao.insertUserByClasss(classs_id,list);
    }

    @Override
    public int updateOneClasss(String classs_name,int classs_id) {
        return classsDao.updateOneClasss(classs_name,classs_id);
    }

    @Override
    public List<Classs> selectClassLike(String select_classs, int before, int after) {
        return classsDao.selectClassLike(select_classs, before, after);
    }

    @Override
    public int selectAllClasssCountLike(String select_classs) {
        return classsDao.selectAllClasssCountLike(select_classs);
    }


}
