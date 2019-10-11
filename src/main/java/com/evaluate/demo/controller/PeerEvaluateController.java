//package com.evaluate.demo.controller;
//
//import com.evaluate.demo.entity.Batch;
//import com.evaluate.demo.entity.Msg;
//import com.evaluate.demo.entity.User;
//import com.evaluate.demo.service.BatchService;
//import com.evaluate.demo.service.PeerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpSession;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//public class PeerEvaluateController {
//    @Autowired
//    private PeerService peerService;
//    @Autowired
//    private BatchService batchService;
//
//    //返回一个同行列表
//    @RequestMapping("/peerEvaluate")
//    public String peerEvaluate(Model model) {
//        Integer evaluates_id = 2;
//        model.addAttribute("evaluates_id", evaluates_id);
//        return "peerEvaluate";
//    }
//
//
//    @RequestMapping("/getPeerTeachers")
//    @ResponseBody
//    public Msg getTeacher(Msg msg, HttpSession session, int bid) {
//        if(bid == 0){
//            msg.setStatus(0);
//            msg.setCode(0);
//            msg.setCount(0);
//            msg.setMsg("获取数据失败！");
//            msg.setData(" ");
//            return msg;
//        }
//        List<Batch> batch = batchService.selectBatch_status(bid);
//        int status = batch.get(0).getBatch_status();
//        String bname = batch.get(0).getBatch_name();
//        if (status == 1) {
//            User user = (User) session.getAttribute("user");
//            List<Map<String, Object>> data = peerService.selectAllPeer(Integer.parseInt(user.getUid()),bname);
//            if (data.size() < 0) {
//                msg.setStatus(0);
//                msg.setCode(0);
//                msg.setCount(0);
//                msg.setMsg("");
//                msg.setData("");
//                return msg;
//            }
//            msg.setCode(0);
//            msg.setCount(10);
//            msg.setMsg("..");
//            msg.setData(data);
//            msg.setStatus(0);
//            return msg;
//        } else {
//            msg.setStatus(0);
//            msg.setCode(0);
//            msg.setCount(0);
//            msg.setMsg("数据失败");
//            msg.setData("");
//            return msg;
//        }
//
//    }
//}
