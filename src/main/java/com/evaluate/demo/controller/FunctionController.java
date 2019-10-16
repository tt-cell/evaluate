package com.evaluate.demo.controller;
import com.evaluate.demo.entity.*;
import com.evaluate.demo.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;

import static java.lang.Integer.parseInt;

@Controller
public class FunctionController {
    @Autowired
    private FunctionService functionService;

    @RequestMapping(value = "/index")
    public ModelAndView goHome(){
        return new ModelAndView("index");
    }

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


    @RequestMapping("/functionMangerment")
    public String getMenu() {
        return "functionMangerment";
    }

    @RequestMapping("/insert")
    public String insert() {
        return "insertFunction";
    }

    @RequestMapping("/getMenu")
    @ResponseBody
    public Msg getMenu(Msg msg, int page,int limit) {

        int before = limit * (page - 1);
        int count = functionService.count();
        List<Function> func = functionService.findPage(before, limit);

        List list = new ArrayList();
        if (func.size() <= 0) {
            msg.setStatus(1);
            msg.setMsg("获取数据失败！");
            msg.setData("");
            return msg;
        }
        for (int i = 0; i < func.size(); i++) {
            Map<String, Object> data = new HashMap<>();
            data.put("id", func.get(i).getFid());
            data.put("fname", func.get(i).getFname());
            data.put("sort", func.get(i).getSort());
            list.add(data);
        }
        msg.setCode(0);
        msg.setStatus(0);
        msg.setMsg("获取数据成功！");
        msg.setCount(count);
        msg.setData(list);
        return msg;
    }

    @RequestMapping("/updateFun")
    @ResponseBody
    public int updateFun(Integer fid, String fname) {
        int result = functionService.updateFun(fid, fname);
        return result;
    }

    @RequestMapping("/deleteFun")
    @ResponseBody
    public int deleteFun(Integer fid) {
        int result = functionService.deleteFun(fid);
        return result;
    }

    @RequestMapping("/insertFun")
    @ResponseBody
    public int insertFun(Function function) {
        int result = functionService.insertFun(function);
        return result;
    }

    @RequestMapping("/giveFunctionToRole")
    public ModelAndView giveFunctionToRole(){
        return new ModelAndView("insertRolesFunction");
    }


    @RequestMapping("/insertRolesFunction")
    @ResponseBody
    public int insertRolesFunction(RoleFunction roleFunction) {
        int result = functionService.insertRolesFunction(roleFunction);
        if(result>0)
        return result;
        else
            return 0;
    }

    @RequestMapping("/selectAllTheFunction")
    @ResponseBody
    public Msg selectAllTheFunction(Msg msg){
        List<Function> functionList = functionService.selectAllTheFunction();
        List data = new ArrayList();
        if(functionList.size()<0){
            msg.setMsg("获取数据失败");
            msg.setData("");
            msg.setCode(1);
            return msg;
        }
        for(int i = 0;i<functionList.size();i++){
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("fid",functionList.get(i).getFid());
            map.put("fname",functionList.get(i).getFname());
            data.add(map);
        }
        msg.setCode(0);
        msg.setStatus(0);
        msg.setMsg("获取数据成功！");
        msg.setData(data);
        return msg;
    }

    @RequestMapping("/selectAllTheFatherFunction")
    @ResponseBody
    public Msg selectAllTheFatherFunction(Msg msg){
        List<Function> functionList = functionService.selectAllTheFatherFunction();
        List data = new ArrayList();
        if(functionList.size()<0){
            msg.setMsg("获取数据败");
            msg.setData("");
            msg.setCode(1);
            return msg;
        }
        for(int i = 0;i<functionList.size();i++){
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("fid",functionList.get(i).getFid());
            map.put("fname",functionList.get(i).getFname());
            data.add(map);
        }
        msg.setCode(0);
        msg.setStatus(0);
        msg.setMsg("获取数据功！");
        msg.setData(data);
        return msg;
    }

}
