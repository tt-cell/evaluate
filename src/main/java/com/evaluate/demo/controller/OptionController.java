package com.evaluate.demo.controller;



import com.evaluate.demo.entity.Msg;
import com.evaluate.demo.entity.Option;
import com.evaluate.demo.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OptionController {
    @Autowired
    private OptionService optionService;

    @RequestMapping("/optionManagement")
    public String Option(){
        return "targetManagement";
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

    @RequestMapping("/updateOption")
    @ResponseBody
    public int updateOption(int oid,String oname){
        int res = optionService.updateOption(oid,oname);
        return  res;

    }

}
