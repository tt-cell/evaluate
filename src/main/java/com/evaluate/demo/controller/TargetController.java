package com.evaluate.demo.controller;



import com.evaluate.demo.entity.Msg;
import com.evaluate.demo.entity.Target;
import com.evaluate.demo.service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class TargetController {
    @Autowired
    private TargetService targetService;

    @RequestMapping("/targetManagement")
    public String Target(){
        return "targetManagement";
    }

    @RequestMapping("/aaa")
    public String aaa(){
        return "aaa";
    }

    @RequestMapping("/targetOption")
    public String TargetOption(){
        return "targetOption";
    }

    @RequestMapping(value = "/getTargets")
    @ResponseBody
    //获取树形菜单的后台接口
    public Msg getMenuTree(Msg msg) {
        List<Map<String, Object>> data = targetService.getTreeList();
        //获取数据，并获取树形菜单的数据
        msg.setStatus(1);
        msg.setMsg("获取数据成功！");
        msg.setData(data);
        return msg;
    }

    @RequestMapping("/selectTarget")
    @ResponseBody
    public Msg selectTarget(Msg msg){
        List<Target> data = targetService.selectTarget();
        msg.setCode(0);
        msg.setCount(5);
        msg.setMsg("成功");
        msg.setData(data);
        msg.setStatus(0);
        return msg;
    }

    @RequestMapping("/selectTitle")
    @ResponseBody
    public Msg selectTitle(Msg msg,int tid){
        List<Target> data = targetService.selectTitle(tid);
        msg.setCode(0);
        msg.setCount(5);
        msg.setMsg("成功");
        msg.setData(data);
        msg.setStatus(0);
        return msg;
    }

    @RequestMapping("/updateTarget")
    @ResponseBody
    public int updateTarget(Integer tid,String tname,String tweight){
        int res = targetService.updateTarget(tid,tname,tweight);
        return  res;
    }

    @RequestMapping("/deleteTarget")
    @ResponseBody
    public int deleteTarget(Integer tid ){
        int res = targetService.deleteTarget(tid);
        return  res;
    }

}
