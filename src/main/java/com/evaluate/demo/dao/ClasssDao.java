package com.evaluate.demo.dao;

import com.evaluate.demo.entity.Classs;
import com.evaluate.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClasssDao {
    //查询所有的班级
    List<Classs> selectAllClasss(@Param("before")int before,@Param("after")int after);
    //查询班级个数
    int selectAllClasssCount();
    //查询某个班级的所有用户
    List<User> selectUsersByClasss(@Param("classs_id") int classs_id);
    //增加班级
    int insertOneClass(@Param("classs_name") String classs_name, @Param("classs_code") String classs_code);
    //增加某个班级的用户
    int insertUserByClasss(@Param("classs_id") int classs_id, @Param("list") List<Integer> list);
    //修改某个班级
    int updateOneClasss(@Param("classs_name") String classs_name,@Param("classs_id") int classs_id);
    //模糊查询班级分页
    List<Classs> selectClassLike(@Param("select_classs")String select_classs,@Param("before")int before,@Param("after")int after);
    //模糊查询班级个数
    int selectAllClasssCountLike(@Param("select_classs")String select_classs);
}
