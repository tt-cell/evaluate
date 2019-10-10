package com.evaluate.demo.controller;

import com.evaluate.demo.entity.User;
import com.evaluate.demo.service.PeerRevicwService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PeerReviewController {
    @Autowired
    private PeerRevicwService peerRevicwService;

    @RequestMapping("/getPeerReviewManagement")
    @ResponseBody
    public ModelAndView getPeerReviewManagement(){
        return new ModelAndView("PeerReviewPage");
    }
    //返回一个同行列表
    @RequestMapping("/getAllPeer")
    @ResponseBody
    public Map getAllClasss(int page,int limit,int uid){
        int before = limit * (page - 1);
        int after = limit;
        Map<String,Object> map = new HashMap<>();
        List<User> users = peerRevicwService.selectAllPeer(uid,before,after);
        map.put("data",users);
        map.put("msg", "");
        map.put("code",0);
        map.put("count", peerRevicwService.countPeer(uid));
        return map;
    }
}
