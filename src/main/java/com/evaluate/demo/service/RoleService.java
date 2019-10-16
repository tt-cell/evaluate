package com.evaluate.demo.service;


import com.evaluate.demo.entity.Role;
import com.evaluate.demo.entity.User;
import com.evaluate.demo.entity.UserRole;

import java.util.List;
import java.util.Map;


public interface RoleService {
    List<Map<String, Object>> selectAllRole(int before,int after);
    int count();

    int updateRole(int rid, int uid);

    //查询所有用户
    List<User> selectAllTheUsers();
    //查询所有角色
    List<UserRole> selectAllTheUsersRoles();
    //插入用户角色
    int insertUserRole(UserRole userRole);
}
