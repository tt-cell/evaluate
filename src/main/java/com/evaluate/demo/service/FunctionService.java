package com.evaluate.demo.service;

import com.evaluate.demo.entity.Function;
import com.evaluate.demo.entity.SonFunction;
import com.evaluate.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface FunctionService {
    List<User> selectUserName(String uname);

    List<Function> selectAllFunction(String uid);
    String selectRnameToUid(String uid);
    List<SonFunction> selectSonFunction(String uid);

    //通过fid来获取各个一级菜单和二级菜单的结点
    List<Map<String, Object>> getTreeList(Integer fid,String rid);
}
