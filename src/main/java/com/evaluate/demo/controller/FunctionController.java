package com.evaluate.demo.controller;
import com.evaluate.demo.entity.*;
import com.evaluate.demo.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;

@Controller
public class FunctionController {
    @Autowired
    private FunctionService functionService;

    @RequestMapping(value = "/login")
    //登录方法
    public ModelAndView getLogin(String uname, String password, ModelAndView modelAndView, HttpSession session) {
        List<User> userList = functionService.selectUserName(uname);
        String theNextView = "index";
        Map<String, String> nextParam = new HashMap<String, String>();
        if (userList == null || userList.isEmpty() || userList.equals("")) {
            theNextView = "login";
        } else {
            User user = userList.get(0);
            if (!user.getPassword().equals(password)) {
                theNextView = "login";
            } else {
                nextParam.put("uname", uname);
                //查询每个用户对应的角色、功能
                session.setAttribute("user", userList.get(0));
            }
        }
        modelAndView.setViewName(theNextView);
        return modelAndView;
    }

    @RequestMapping(value = "/menu")
    @ResponseBody
    //获取树形菜单的后台接口
    public Msg getMenuTree(Msg msg, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<User> userList = functionService.selectUserName(user.getUname());
        if(userList == null || userList.isEmpty() || userList.equals("")){
            msg.setStatus(0);
            msg.setMsg("获取数据失败！");
            msg.setData("");
            return msg;
        }
        String rid = functionService.selectRnameToUid(userList.get(0).getUid());
        List<Map<String, Object>> data = functionService.getTreeList(0,rid);
        //获取数据，并获取树形菜单的数据
        msg.setStatus(1);
        msg.setMsg("获取数据成功！");
        msg.setData(data);
        return msg;
    }

    //判断登录用户是否正确
    @RequestMapping(value = "/isLoginRight")
    @ResponseBody
    public Map checkUser(String uname,String password){
        Map<String,Integer> rs = new HashMap<String,Integer>();
        List<User> users = functionService.selectUserName(uname);
        User user = users.get(0);
        if(!user.getUname().equals(uname)||!user.getPassword().equals(password)){
            rs.put("state",2);
        }else if(user.getUname().equals("")||user.getPassword().isEmpty()||
                user.getPassword().equals("")||user.getPassword().isEmpty()){
            rs.put("state",1);
        }else {
            rs.put("state",0);
        }
        return rs;
    }
}
