package com.evaluate.demo.service.Impl;



import com.evaluate.demo.dao.UserDao;
import com.evaluate.demo.entity.Colleges;
import com.evaluate.demo.entity.User;

import com.evaluate.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;


    @Override
    public int insertOneUser(String uname, String password) {
        return userDao.insertOneUser(uname,password);
    }

    @Override
    public List<User> selectCheckUsername(String uname) {
        return null;
    }

    @Override
    public List<User> selectCheckUser(String uname, String password) {
        return null;
    }

    @Override
    public int updateOneUser(String uname, int uid) {
        return userDao.updateOneUser(uname,uid);
    }

    @Override
    public List<User> selectAllUser() {
        return userDao.selectAllUser();
    }

    @Override
    public int deleteOneUser(int uid) {
        return userDao.deleteOneUser(uid);
    }

    @Override
    public List<User> selectOneUser(int uid) {
        return userDao.selectOneUser(uid);
    }

    @Override
    public List<User> findAllPage(int before, int after) {
        return userDao.findAllPage(before,after);
    }

    @Override
    public int count() {
        return userDao.count();
    }

    @Override
    public int insertOneUser(String uname,String password,int sex,int colleges_id){
        return userDao.insertOneUser(uname,password,sex,colleges_id);
    }

    @Override
    public List<Colleges> selectAllColleges() {
        return userDao.selectAllColleges();
    }

    @Override
    public int selectOneColleges_id(String Colleges_name) {
        return userDao.selectOneColleges_id(Colleges_name);
    }
}
