package com.evaluate.demo.service;


import com.evaluate.demo.entity.Colleges;
import com.evaluate.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public interface UserService {
    int insertOneUser(String uname,String password);
    List<User> selectCheckUsername(String uname);
    List<User> selectCheckUser(String uname,String password);
    int updateOneUser(String uname,int uid);
    List<User> selectAllUser();
    int deleteOneUser(int uid);
    List<User> selectOneUser(int uid);
    public List<Map<String,Object>> findAllPage(int before, int after);
    public int count();

    int insertOneUser(User user);
    List<Colleges> selectAllColleges();
    int selectOneColleges_id(String Colleges_name);



    List<Colleges> selectCollegeId(String colleges_name);

    //查询所有老师
    List<User> selectAllTheTeacher();
}
