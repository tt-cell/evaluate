package com.evaluate.demo.controller;
import com.evaluate.demo.entity.Msg;
import com.evaluate.demo.entity.User;
import com.evaluate.demo.entity.UserRole;
import com.evaluate.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/roleManagement")
    public String Role(){
        return "roleManagement";
    }


    //查询所有用户的角色
    @RequestMapping("/selectAllRole")
    @ResponseBody
    public Msg selectAllRole(Msg msg,int page,int limit){
        int before =limit * (page - 1);
        int after = limit;
        List<Map<String, Object>> data = roleService.selectAllRole(before,after);
        int count = roleService.count();
        msg.setCode(0);
        msg.setMsg("成功");
        msg.setCount(count);
        msg.setData(data);
        return msg;
    }

    @RequestMapping("/upRole")
    public String upRole(){
        return "modifyRole";
    }

    //修改角色
    @RequestMapping("/updateRole")
    @ResponseBody
    public int updateRole(int rid,int uid){
        return roleService.updateRole(rid,uid);
    }

    //查询所有的用户
    @RequestMapping("/selectAllTheUsers")
    @ResponseBody
    public Map selectAllTheUsers(){
        List<User> userList = roleService.selectAllTheUsers();
        Map<String,Object> map = new LinkedHashMap<>();
        if(userList.size()>0){
            map.put("code",0);
            map.put("msg","");
            map.put("data",userList);
            return map;
        }else {
            map.put("code",1);
            map.put("msg","获取数据失败");
            map.put("data",userList);
            return map;
        }
    }

    //查询所有用户角色
    @RequestMapping("/selectAllTheUsersRoles")
    @ResponseBody
    public Map selectAllTheUsersRoles(){
        List<UserRole> userRoleList = roleService.selectAllTheUsersRoles();
        List<User> userList = roleService.selectAllTheUsers();
        for (int i = 0;i<userList.size();i++){
            for (int j = 0;j<userRoleList.size();j++){
                if (Integer.parseInt(userList.get(i).getUid())==userRoleList.get(j).getUid()){
                    userList.remove(userList.get(i));
                }
            }

        }

        Map<String,Object> map = new LinkedHashMap<>();
        if(userList.size()>0){
            map.put("code",0);
            map.put("msg","获取数据成功");
            map.put("data",userList);
            return map;
        }else {
            map.put("code",1);
            map.put("msg","获取数据失败");
            map.put("data",userList);
            return map;
        }
    }

        @RequestMapping("/insertUserRole")
        @ResponseBody
        //插入用户角色
        public int insertUserRole(UserRole userRole){
            int rs = roleService.insertUserRole(userRole);
            if(rs>0)
                return rs;
            else
                return 0;
        }

    }
