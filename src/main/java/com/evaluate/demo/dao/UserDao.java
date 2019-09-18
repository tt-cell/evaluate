package com.evaluate.demo.dao;

import com.evaluate.demo.entity.Colleges;
import com.evaluate.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    //    插入一个新用户
    int insertOneUser(@Param("uname") String uname, @Param("password")String password); //@Param用户多个参数映射

    //    获得所有用户
    List<User> selectAllUser();

    //更改一个用户
    int updateOneUser(@Param("uname") String uname, @Param("uid") int uid);

    //    删除一个用户
    int deleteOneUser(int uid);

    //    查询一个用户
    List<User> selectOneUser(int uid);

    // 分页
    public List<User> findAllPage(@Param("before") int before,@Param("after") int after);
    public int count();

    int insertOneUser(@Param("uname") String uname,@Param("password") String password,@Param("sex") int sex,@Param("colleges_id") int colleges_id);

    List<Colleges> selectAllColleges();
    int selectOneColleges_id(String Colleges_name);
}






