package com.evaluate.demo.controller;


import com.evaluate.demo.entity.Msg;
import com.evaluate.demo.entity.Option;
import com.evaluate.demo.entity.TargetOption;
import com.evaluate.demo.service.OptionService;
import com.evaluate.demo.service.RoleService;
import com.evaluate.demo.service.UserService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class OptionController {
    @Autowired
    private OptionService optionService;

    @RequestMapping("/optionManagement")
    public String Option() {
        return "targetManagement";
    }

    @RequestMapping("/insertOp")
    public String insertOp() {
        return "insertOp";
    }


    @RequestMapping("/getOption")
    @ResponseBody
    public Msg getOption(Msg msg, int tid) {
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
    public Msg selectTarget(Msg msg, int tid) {
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
    public Msg selectAllTheOption(Msg msg) {
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
    public int updateOption(int oid, String oname) {
        int res = optionService.updateOption(oid, oname);
        return res;

    }

    //批量插入批次选项
    @RequestMapping("/insertOption")
    @ResponseBody
    public int insertOption(@RequestParam("options_id") String options_id, int targets_id) {
        JSONArray ary = JSONArray.fromObject(options_id);
        int flag = 0;
        for (Object m : ary) {
            Map map1 = (Map) m;
            int oid = Integer.parseInt((String) map1.get("index"));
            int res = optionService.insertOption(targets_id, oid);
            if(res>0){
                flag = 1;
            }
        }
        return flag;
    }
}
