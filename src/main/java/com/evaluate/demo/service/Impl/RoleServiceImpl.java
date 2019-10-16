package com.evaluate.demo.service.Impl;

import com.evaluate.demo.dao.RoleDao;
import com.evaluate.demo.entity.Role;
import com.evaluate.demo.entity.User;
import com.evaluate.demo.entity.UserRole;
import com.evaluate.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Map<String, Object>> selectAllRole(int before,int after) {
        return roleDao.selectAllRole(before,after);
    }

    @Override
    public int count() {
        return roleDao.count();
    }

    @Override
    public int updateRole(int rid,int uid) {
        return roleDao.updateRole(rid,uid);
    }

    @Override
    public List<User> selectAllTheUsers() {
        return roleDao.selectAllTheUsers();
    }

    @Override
    public List<UserRole> selectAllTheUsersRoles() {
        return roleDao.selectAllTheUsersRoles();
    }

    @Override
    public int insertUserRole(UserRole userRole) {
        return roleDao.insertUserRole(userRole);
    }

}
