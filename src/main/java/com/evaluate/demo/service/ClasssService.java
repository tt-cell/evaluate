package com.evaluate.demo.service;

import com.evaluate.demo.entity.Classs;
import com.evaluate.demo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClasssService {
    List<Classs> selectAllClasss(int before,int after);
    int selectAllClasssCount();
    List<User> selectUsersByClasss(int classs_id);
    int insertOneClass(String classs_name, String classs_code);
    int insertUserByClasss(int classs_id, List<Integer> list);
    int updateOneClasss(String classs_name,int classs_id);
    List<Classs> selectClassLike(String select_classs,int before,int after);
    int selectAllClasssCountLike(String select_classs);

}
