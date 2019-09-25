package com.evaluate.demo.controller;
import com.evaluate.demo.entity.Msg;
import com.evaluate.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

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
    public Msg selectAllRole(Msg msg){
        List<Map<String, Object>> data = roleService.selectAllRole();
        msg.setCode(0);
        msg.setMsg("成功");
        msg.setCount(3);
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
    public int updateRole(String rid,String uid){
        return roleService.updateRole(rid,uid);
    }



}
