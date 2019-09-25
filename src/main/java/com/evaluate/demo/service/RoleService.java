package com.evaluate.demo.service;


import com.evaluate.demo.entity.Role;

import java.util.List;
import java.util.Map;


public interface RoleService {
    List<Map<String, Object>> selectAllRole();

    int updateRole(String rid, String uid);
}
