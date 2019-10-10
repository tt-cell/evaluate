package com.evaluate.demo.controller;

import com.evaluate.demo.entity.Msg;
import com.evaluate.demo.entity.Option;
import com.evaluate.demo.entity.Target;
import com.evaluate.demo.service.StudentTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentTargetsController {
    @Autowired
    private StudentTargetService studentTargetService;

    @RequestMapping("/selectEvaluateTargets")
    @ResponseBody
    public Msg getStudentTargets(Msg msg, Integer evaluates_id){
        List<Target> targetList = studentTargetService.selectStudentTargets(evaluates_id);
        //List<Option> optionList = studentTargetService.selectStudentOptions();
        System.out.println(evaluates_id);
        if(targetList.size()<=0){
            msg.setCode(1);
            msg.setMsg("获取数据失败");
            return msg;
        }

        List listOne = new ArrayList();
        //List list = new ArrayList();
        for(int i = 0;i<targetList.size();i++){
            Map<String,Object> mapOne = new HashMap<>();
            mapOne.put("targets_name",targetList.get(i).getTargets_name());
            mapOne.put("targets_id",targetList.get(i).getTargets_id());
            mapOne.put("options_name",targetList.get(i).getOptions_name().split(","));
            listOne.add(mapOne);
        }

        msg.setCode(0);
        msg.setMsg("获取数据成功");
        msg.setData(listOne);
        msg.setStatus(evaluates_id);
        return msg;

    }
}
