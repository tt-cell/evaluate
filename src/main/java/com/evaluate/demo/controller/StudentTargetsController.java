package com.evaluate.demo.controller;

import com.evaluate.demo.entity.Msg;
import com.evaluate.demo.entity.Option;
import com.evaluate.demo.entity.Target;
import com.evaluate.demo.service.StudentTargetService;
import com.evaluate.demo.service.TeacherService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentTargetsController {
    @Autowired
    private StudentTargetService studentTargetService;
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/selectEvaluateTargets")
    @ResponseBody
    public Msg getStudentTargets(Msg msg, Integer evaluates_id) {
        List<Target> targetList = studentTargetService.selectStudentTargets(evaluates_id);
        //List<Option> optionList = studentTargetService.selectStudentOptions();
//        System.out.println(evaluates_id);
        if (targetList.size() <= 0) {
            msg.setCode(1);
            msg.setMsg("获取数据失败");
            return msg;
        }

        List listOne = new ArrayList();
        //List list = new ArrayList();
        for (int i = 0; i < targetList.size(); i++) {
            Map<String, Object> mapOne = new HashMap<>();
            mapOne.put("targets_name", targetList.get(i).getTargets_name());
            mapOne.put("targets_id", targetList.get(i).getTargets_id());
            mapOne.put("options_name", targetList.get(i).getOptions_name().split(","));
            listOne.add(mapOne);
        }

        msg.setCode(0);
        msg.setMsg("获取数据成功");
        msg.setData(listOne);
        msg.setStatus(evaluates_id);
        return msg;

    }

    @RequestMapping("/testValue")
    @ResponseBody
    public float testValue(@RequestParam("list") String list) {
        JSONArray ary = JSONArray.fromObject(list);
        float sum = 0;
        Map map = new HashMap();
        for (Object m : ary) {
            Map map1 = (Map) m;
            int aa = Integer.parseInt((String) map1.get("index"));
            String bb = (String) map1.get("value");
            List<Target> a = teacherService.getTweight(aa);
            List<Option> b = teacherService.getOweight(bb);
            float tM = a.get(0).getTargets_weight();
            float oM = b.get(0).getOptions_weight();
            sum = (float) (sum + (Math.floor(tM * 1000) / 1000) * (Math.floor(oM * 1000) / 1000));
//            System.out.println(Math.floor(sum*100)/100);
        }
        return (float) (Math.floor(sum * 1000) / 1000) * 100;
    }
}
