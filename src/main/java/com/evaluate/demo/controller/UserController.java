package com.evaluate.demo.controller;
import com.evaluate.demo.entity.Colleges;
import com.evaluate.demo.entity.User;
import com.evaluate.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

        @Autowired
        private UserService userService;


        //    所有用户
        @RequestMapping("/getA")
        @ResponseBody
        public ModelAndView getA() {
            ModelAndView modelAndView = new ModelAndView("Test");
            return modelAndView;
        }

    //    所有用户
    @RequestMapping("/getAllUser")
    @ResponseBody
    public ModelAndView getAllUser() {
        ModelAndView modelAndView = new ModelAndView("user");
        return modelAndView;
    }
//        //    注册一个用户
//        @RequestMapping("/insertOneUser")
//        public int insertOneUser(String uname, String password) {
//            int result = userService.insertOneUser(uname, password);
//            return result;
//        }

        //更改一个用户
        @RequestMapping("/changeOneUser")
        @ResponseBody
        public Map changeOneUser(String uname, int userId) {
            int result = userService.updateOneUser(uname, userId);
            Map<String, Object> map = new HashMap<>();
            if (result >= 0) {
                map.put("flag", "success");
            }

//        ModelAndView modelAndView = new ModelAndView("redirect:/user/getAllUser");//redirect
            return map;
        }

        //删除一个用户
        @RequestMapping("/deleteOneUser")

        public @ResponseBody
        List deleteOneUser(int userId) {
            int result = userService.deleteOneUser(userId);

            List<User> users = userService.selectAllUser();

            return users;
        }



//        @RequestMapping("/getOneUser")
//        @ResponseBody
//        public ModelAndView getOneUser(int userId) {
//
//            List<User> users = userService.selectOneUser(userId);
//            ModelAndView view = new ModelAndView("users");
//            view.addObject("users", users);
//            return view;
//        }


        @RequestMapping("/getAllUsers")
        @ResponseBody
        public Map getAllUsers(int page, int limit) {
            int before = limit * (page - 1);
            int after = page * limit;
            List<User> users = userService.findAllPage(before, after);
            int count = userService.count();
            Map<String, Object> map = new HashMap<>();

//        JSONArray json = JSONArray.fromObject(users);
            map.put("code", 0);
            map.put("msg", "");
            map.put("count", count);
            map.put("data", users);
//        System.out.println(json);
//        String js = json.toString();
//        //*****转为layui需要的json格式，必须要这一步，博主也是没写这一步，在页面上数据就是数据接口异常
////        String jso = "{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":"+js+"}";
//        String jso = "{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":"+js+"}";
//        System.out.println(jso);
            return map;
        }

    @RequestMapping("/getAllColleges")
    @ResponseBody
    public Map getAllColleges(){
       List<Colleges> list = userService.selectAllColleges();
        Map<String, Object> map = new HashMap<>();
        map.put("Colleges",list);
        map.put("code",0);
        return map;
    }

    @RequestMapping("/getAddUserPage")
    @ResponseBody
    public ModelAndView getAddUserPage(){
        ModelAndView modelAndView =new ModelAndView("addUser");
        return modelAndView;
    }

    //    获得一个用户
    @RequestMapping(value = "/AddOneUser")
    @ResponseBody
    public Map AddOneUser(String uname,String password,int sex,String colleges_name){
        int colleges_id = userService.selectOneColleges_id(colleges_name);
        int result = userService.insertOneUser(uname,password,sex,colleges_id);
        Map<String,Object> map = new HashMap<>();
        if(result>=0){
            map.put("flag","success");
        }
        return map;
    }

    }
