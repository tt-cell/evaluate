package com.evaluate.demo.controller;


import com.evaluate.demo.entity.Batch;
import com.evaluate.demo.entity.Msg;
import com.evaluate.demo.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BatchController {
    @Autowired
    private BatchService batchService;

    @RequestMapping("/batchManagement")
    public String Batch(){
        return "batchManagement";
    }

    @RequestMapping("/getBatch")
    @ResponseBody
    public Msg getBatch(Msg msg){
        List<Batch> data = batchService.selectBatch();
        if(data.size()<0){
            msg.setStatus(0);
            msg.setCode(0);
            msg.setCount(5);
            msg.setMsg("获取数据失败！");
            msg.setData("");
            return msg;
        }
        msg.setCode(0);
        msg.setCount(5);
        msg.setMsg("成功");
        msg.setData(data);
        msg.setStatus(0);
        return msg;
    }

    @RequestMapping("/updateBatch")
    @ResponseBody
    public int updateBatch(int batch_id,int batch_status){
        //更新状态
        return batchService.updateBatch(batch_id,batch_status);
    }

}
