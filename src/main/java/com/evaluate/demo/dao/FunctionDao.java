package com.evaluate.demo.dao;

import com.evaluate.demo.entity.Function;
import com.evaluate.demo.entity.RoleFunction;
import com.evaluate.demo.entity.SonFunction;
import com.evaluate.demo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FunctionDao {
    List<User> selectUserName(String uname);


    List<Function> selectAllFunction(String uid);
    String selectRnameToUid(String uid);
    List<SonFunction> selectSonFunction(String uid);

    //获取树形菜单的信息
    List<Function> getTreeLists(String rid);


    //改
    int updateFun(int fid, String fname);

    //删
    int deleteFun(int fid);

    //增
    int insertFun(Function function);

    //分页
    List<Function> findPage(@Param("before") int before, @Param("after") int after);
    int count();

    //分配权限
    int insertRolesFunction(RoleFunction roleFunction);

    //查询所有功能
    List<Function> selectAllTheFunction();
}
