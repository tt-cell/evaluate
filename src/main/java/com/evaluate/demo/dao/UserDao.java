package com.evaluate.demo.dao;

import com.evaluate.demo.entity.Colleges;
import com.evaluate.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao {
    //    插入一个新用户
    int insertOneUser(@Param("uname") String uname, @Param("password")String password); //@Param用户多个参数映射

    //    获得所有用户
    List<User> selectAllUser();

    // 分页
    public List<Map<String,Object>> findAllPage(@Param("before") int before, @Param("after") int after);
    public int count();

    //    插入一个新用户
    int insertOneUser(User user);

    //    删除一个用户
    int deleteOneUser(int uid);

    //更改一个用户
    int updateOneUser(@Param("uname") String uname, @Param("uid") int uid);

    //    查询一个用户
    List<User> selectOneUser(int uid);

    //查询所有学院
    List<Colleges> selectAllColleges();
    int selectOneColleges_id(String Colleges_name);

    List<Colleges> selectCollegeId(String colleges_name);
}






