package com.evaluate.demo.controller;

import com.evaluate.demo.entity.ClassParam;
import com.evaluate.demo.entity.Classs;
import com.evaluate.demo.entity.User;
import com.evaluate.demo.service.ClasssService;
import javafx.beans.binding.ObjectExpression;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.text.html.parser.Parser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ClasssController {
    @Autowired
    private ClasssService classsService;
    //返回classs页面
    @RequestMapping("/getClasssManagement")
    @ResponseBody
    public ModelAndView getAllClasss() {
        ModelAndView modelAndView = new ModelAndView("classsManagement");
        return modelAndView;
    }
    //返回插入班级页面
    @RequestMapping("/getInsertClasssPage")
    @ResponseBody
    public ModelAndView getInsertClasssPage() {
        ModelAndView modelAndView = new ModelAndView("insertClasss");
        return modelAndView;
    }
    //返回插入班级的用户
    @RequestMapping("/insertUserInClasssPage")
    @ResponseBody
    public ModelAndView insertUserInClasssPage(int classs_id,Model model) {
        ModelAndView modelAndView = new ModelAndView("insertUserInClasss");
      model.addAttribute("classs_id",classs_id);
        return modelAndView;
    }
    //返回查询班级列表
    @RequestMapping("/selectClaassPage")
    @ResponseBody
    public ModelAndView selectClaassPage(String select_classs) {
        ModelAndView modelAndView = new ModelAndView("selectClasss");
      modelAndView.addObject("select_classs",select_classs);
        return modelAndView;
    }
    //返回一个班级列表
    @RequestMapping("/getAllClasss")
    @ResponseBody
    public Map getAllClasss(int page,int limit){
        int before = limit * (page - 1);
        int after = limit;
        Map<String,Object> map = new HashMap<>();
        List<Classs> classs = classsService.selectAllClasss(before,after);
        map.put("data",classs);
        map.put("msg", "");
        map.put("code",0);
        map.put("count", classsService.selectAllClasssCount());
        return map;
    }
    //模糊查询班级表格
    @RequestMapping("/selectClassLike")
    @ResponseBody
    public Map selectClassLike(String select_classs,int page,int limit){
        int before = limit * (page - 1);
        int after = limit;
        int code = 0;
        Map<String,Object> map = new HashMap<>();
        List<Classs> classs = classsService.selectClassLike(select_classs,before,after);
        map.put("data",classs);
        map.put("msg", "");
        map.put("code",code);
        map.put("count", classsService.selectAllClasssCountLike(select_classs));

        return map;
    }
    //返回一个班级的所有用户列表
    @RequestMapping("/getOneClasssAllUser")
    @ResponseBody
    public Map getOneClasssAllUser(int classs_id){
        Map<String,Object> map = new HashMap<>();
        List<User> users = classsService.selectUsersByClasss(classs_id);
        map.put("users",users);
        return map;
    }
    //增加一个班级
    @RequestMapping("/addOneClasss")
    @ResponseBody
    public Map addOneClasss(String classs_name,String classs_code){
        Map<String,Object> map = new HashMap<>();
        int result = classsService.insertOneClass(classs_name,classs_code);
        if (result>0){
            map.put("flag","success");
        }
        return map;
    }
    //增加一个班级里的用户
    @RequestMapping("/addOneClasssUser")
    @ResponseBody
    public Map addOneClasssUser(@RequestParam("list")String list,@RequestParam("classs_id")int classs_id){
        List<User> users = classsService.selectUsersByClasss(classs_id);
        JSONArray ary = JSONArray.fromObject(list);
        List<Integer> list1 = JSONArray.toList(ary,new ArrayList<>(), new JsonConfig());
           for (int i = 0;i<list1.size();i++){
              for(int j = 0;j<users.size();i++){
                  if(list1.get(i)==Integer.valueOf(users.get(j).getUid())){
                      list1.remove(i);
                      break;
                  }
              }
           }
//        List<String> list = new ArrayList();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        for (int i = 0;i<list.size();i++){
//            list1.add(Integer.parseInt(list.get(i).getUid()));
//        }
//        param.getList().stream().forEach(item->{
//            list1.add(Integer.parseInt(item.getUid()));
//        });
        Map<String,Object> map = new HashMap<>();
        int result = classsService.insertUserByClasss(classs_id,list1);
        if (result>0){
            map.put("flag","success");
        }
        return map;
    }
    //修改一个班级
    @RequestMapping("/updateOneClasss")
    @ResponseBody
    public Map updateOneClasss(String classs_name,int classs_id){
        Map<String,Object> map = new HashMap<>();
        int result = classsService.updateOneClasss(classs_name,classs_id);
        if (result>0){
            map.put("flag","success");
        }
        return map;
    }




}
