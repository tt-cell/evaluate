package com.evaluate.demo.controller;



import com.evaluate.demo.entity.Msg;
import com.evaluate.demo.entity.Option;
import com.evaluate.demo.entity.TargetOption;
import com.evaluate.demo.service.OptionService;
import com.evaluate.demo.service.RoleService;
import com.evaluate.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OptionController {
    @Autowired
    private OptionService optionService;

    @RequestMapping("/optionManagement")
    public String Option(){
        return "targetManagement";
    }

    @RequestMapping("/insertOp")
    public String insertOp(){
        return "insertOp";
    }



    @RequestMapping("/getOption")
    @ResponseBody
    public Msg getOption(Msg msg,int tid){
        List<Option> data = optionService.selectOption(tid);
        msg.setCode(0);
        msg.setCount(20);
        msg.setMsg("成功");
        msg.setData(data);
        msg.setStatus(0);
        return msg;
    }

    @RequestMapping("selectAllOption")
    @ResponseBody
    public Msg selectTarget(Msg msg, int tid){
        List<Option> data = optionService.selectAllOption(tid);
        msg.setCode(0);
        msg.setCount(5);
        msg.setMsg("成功");
        msg.setData(data);
        msg.setStatus(0);
        return msg;
    }

    @RequestMapping("selectAllTheOption")
    @ResponseBody
    public Msg selectAllTheOption(Msg msg){
        List<Option> data = optionService.selectAllTheOption();
        msg.setCode(0);
        msg.setCount(5);
        msg.setMsg("成功");
        msg.setData(data);
        msg.setStatus(0);
        return msg;
    }

    @RequestMapping("/updateOption")
    @ResponseBody
    public int updateOption(int oid,String oname){
        int res = optionService.updateOption(oid,oname);
        return  res;

    }

    //批量插入批次选项
    @RequestMapping("/insertOption")
    @ResponseBody
    public List insertOption(TargetOption targetOption){
        List<Option> optionList = optionService.selectAllTheOption();
        List targetOptions = new ArrayList<>();
        for(int i = 0;i<optionList.size();i++) {
            int res = optionService.insertOption(targetOption);
            targetOptions.add(res);
        }
        return targetOptions;
    }
}
