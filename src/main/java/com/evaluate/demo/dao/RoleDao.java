package com.evaluate.demo.dao;

import com.evaluate.demo.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RoleDao {
    List<Map<String, Object>> selectAllRole();

    int updateRole(String rid, String uid);

}






