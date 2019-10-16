package com.evaluate.demo.controller;
        import com.evaluate.demo.entity.Colleges;
        import com.evaluate.demo.entity.User;
        import com.evaluate.demo.service.UserService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
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

    //所有用户映射的路径
    @RequestMapping("/getUserManagement")
    @ResponseBody
    public ModelAndView getAllUser() {
        ModelAndView modelAndView = new ModelAndView("userManagement");
        return modelAndView;
    }

    //分页查询所有的用户信息
    @RequestMapping("/getAllUsers")
    @ResponseBody
    public Map getAllUsers(int page, int limit) {
        int before = limit * (page - 1);
        List<Map<String,Object>> users = userService.findAllPage(before, limit);
        int count = userService.count();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", count);
        map.put("data", users);
        return map;
    }
    //查询所有的老师信息
    @RequestMapping("/getAllTeachers")
    @ResponseBody
    public Map getAllTeachers() {
        List<User> data = userService.selectAllTheTeacher();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("data", data);
        return map;
    }

    //删除一个用户
    @RequestMapping("/deleteOneUser")
    public @ResponseBody
    int deleteOneUser(int userId) {
        int result = userService.deleteOneUser(userId);
        //List<User> users = userService.selectAllUser();
        if(result>0)
        return result;
        else
            return 1;
    }

    //更改一个用户
    @RequestMapping("/changeOneUser")
    @ResponseBody
    public int changeOneUser(String uname, int uid) {
        int result = userService.updateOneUser(uname,uid);
//        Map<String, Object> map = new HashMap<>();
        if (result >= 0) {
           return result;
        }else
        return 1;
    }
    @RequestMapping("/getAllColleges")
    @ResponseBody
    public Map getAllColleges(){
        List<Colleges> list = userService.selectAllColleges();
        Map<String, Object> map = new HashMap<>();
        map.put("msg","获取数据成功");
        map.put("code",0);
        map.put("Colleges",list);
        return map;
    }

    //弹出框跳转界面
    @RequestMapping("/getAddUserPage")
    @ResponseBody
    public ModelAndView getAddUserPage(){
        ModelAndView modelAndView =new ModelAndView("insertUser");
        return modelAndView;
    }

    //添加一个用户
    @RequestMapping(value = "/AddOneUser")
    @ResponseBody
    public int AddOneUser(User user){
        int result = userService.insertOneUser(user);
        if(result>0)
        return result;
        else
            return 1;
    }



    //添加一个用户
    @RequestMapping(value = "/selectColleges_id")
    @ResponseBody
    public Map AddOneUser(String colleges_name){
        List<Colleges> collegesList = userService.selectCollegeId(colleges_name);
        Map<String,Object> map = new HashMap<>();
        map.put("collegesList",collegesList);
        return map;
    }

    @RequestMapping(value = "/insertTheUserRole")
    public ModelAndView insertUserRole(){
        return new ModelAndView("insertUserRole");
    }


}
