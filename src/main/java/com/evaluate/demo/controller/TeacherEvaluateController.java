package com.evaluate.demo.controller;

import com.evaluate.demo.entity.Batch;
import com.evaluate.demo.entity.Msg;
import com.evaluate.demo.entity.User;
import com.evaluate.demo.service.BatchService;
import com.evaluate.demo.service.StudentService;
import com.evaluate.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class TeacherEvaluateController {
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private BatchService batchService;

    @RequestMapping("/teacherEvaluate")
    public String Role(Model model) {
        Integer evaluates_id = 4;
        model.addAttribute("evaluates_id", evaluates_id);
        return "teacherEvaluate";
    }
    //跳转到评价指标界面
//    @RequestMapping(value = "/teacherTargets")
//    public ModelAndView studentEvaluate (Integer evaluates_id) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("evaluates_id",evaluates_id);
//        modelAndView.setViewName("studentTargets");
//        return modelAndView;
//    }
    @RequestMapping("/getTeachers")
    @ResponseBody
    public Msg getTeacher(Msg msg, HttpSession session, int bid) {
        if(bid == 0){
            msg.setStatus(0);
            msg.setCode(0);
            msg.setCount(0);
            msg.setMsg("获取数据失败！");
            msg.setData(" ");
            return msg;
        }
        List<Batch> batch = batchService.selectBatch_status(bid);
        int status = batch.get(0).getBatch_status();
        String bname = batch.get(0).getBatch_name();
        if (status == 1) {
            User user = (User) session.getAttribute("user");
            List<Map<String, Object>> data = teacherService.selectTeachers(Integer.parseInt(user.getUid()),bname);
            if (data.size() < 0) {
                msg.setStatus(0);
                msg.setCode(0);
                msg.setCount(0);
                msg.setMsg("");
                msg.setData("");
                return msg;
            }
            msg.setCode(0);
            msg.setCount(10);
            msg.setMsg("..");
            msg.setData(data);
            msg.setStatus(0);
            return msg;
        } else {
            msg.setStatus(0);
            msg.setCode(0);
            msg.setCount(0);
            msg.setMsg("数据失败");
            msg.setData("");
            return msg;
        }

    }

}
