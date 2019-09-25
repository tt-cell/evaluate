package com.evaluate.demo.service.Impl;

import com.evaluate.demo.dao.RoleDao;
import com.evaluate.demo.entity.Role;
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
    public List<Map<String, Object>> selectAllRole() {
        return roleDao.selectAllRole();
    }

    @Override
    public int updateRole(String rid,String uid) {
        return roleDao.updateRole(rid,uid);
    }

}
