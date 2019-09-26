package com.evaluate.demo.dao;

import com.evaluate.demo.entity.Role;
import com.evaluate.demo.entity.User;
import com.evaluate.demo.entity.UserRole;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RoleDao {
    List<Map<String, Object>> selectAllRole();

    int updateRole(String rid, String uid);

    //查询所有用户
    List<User> selectAllTheUsers();
    //查询所有角色
    List<UserRole> selectAllTheUsersRoles();
    //插入用户角色
    int insertUserRole(UserRole userRole);
}






