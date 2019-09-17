package com.evaluate.demo.dao;

import com.evaluate.demo.entity.Function;
import com.evaluate.demo.entity.SonFunction;
import com.evaluate.demo.entity.User;

import java.util.List;

public interface FunctionDao {
    List<User> selectUserName(String uname);


    List<Function> selectAllFunction(String uid);
    String selectRnameToUid(String uid);
    List<SonFunction> selectSonFunction(String uid);

    //获取树形菜单的信息
    List<Function> getTreeLists(String rid);
}
