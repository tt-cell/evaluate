package com.evaluate.demo.controller;


import com.evaluate.demo.entity.*;
import com.evaluate.demo.service.BatchService;
import com.evaluate.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BatchController {
    @Autowired
    private BatchService batchService;
    private RoleService roleService;

    @RequestMapping("/batchManagement")
    public String Batch(){
        return "batchManagement";
    }

    @RequestMapping("/insertBa")
    public String InsertBa(){
        return "insertBa";
    }

    @RequestMapping("/insertUsBa")
    public String InsertUsBa(){
        return "insertUsBa";
    }


    //获取所有批次
    @RequestMapping("/getAllTheBatch")
    @ResponseBody
    public Msg getBatch(Msg msg){
        List<Batch> data = batchService.selectAllTheBatch();
        if(data.size()<0){
            msg.setStatus(0);
            msg.setCode(0);
            msg.setMsg("获取数据失败！");
            msg.setData("");
            return msg;
        }
        msg.setCode(0);
        msg.setMsg("成功");
        msg.setData(data);
        msg.setStatus(0);
        return msg;
    }

    //判断用户在这个批次中是否存在
    @RequestMapping("/selectAllTheUsersBatch")
    @ResponseBody
    public Map selectAllTheUsersRoles(){
        List<UserBatch> userBatchList = batchService.selectAllTheUserBatch();
        List<User> userLists = roleService.selectAllTheUsers();
        for (int n = 0;n<userLists.size();n++){
            for (int p = 0;p<userBatchList.size();p++){
                if (Integer.parseInt(userLists.get(n).getUid())!=userBatchList.get(p).getUid()){
                    userLists.add(userLists.get(n));
                }else {
                    userLists.remove(userLists.get(n));
                }
            }

        }
        Map<String,Object> map = new HashMap<>();
        if(userLists.size()>0){
            map.put("code",0);
            map.put("msg","获取成功");
            map.put("data",userLists);
            return map;
        }else {
            map.put("code",1);
            map.put("msg","获取失败");
            map.put("data",userLists);
            return map;
        }

    }


    //分页获取批次
    @RequestMapping("/selectBatchByPage")
    @ResponseBody
    public Msg getBatch(Msg msg,int page,int limit){
        int before = limit *(page - 1);
        int after = limit;
        List<Batch> data = batchService.selectBatchByPage(before,after);
        int count = batchService.count();
        if(data.size()<0){
            msg.setStatus(0);
            msg.setCode(0);
            msg.setCount(count);
            msg.setMsg("获取数据失败！");
            msg.setData("");
            return msg;
        }
        msg.setCode(0);
        msg.setCount(count);
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

    //修改批次
    @RequestMapping("/updateName")
    @ResponseBody
    public int updateName(int batch_id,String batch_name){
        return batchService.updateName(batch_id,batch_name);
    }

    //删除批次
    @RequestMapping("/deleteBatch")
    @ResponseBody
    public int deleteBatch(int batch_id){
        return batchService.deleteBatch(batch_id);
    }

    //添加批次
    @RequestMapping("/insertBatch")
    @ResponseBody
    public int insertBatch(Batch batch){
        return batchService.insertBatch(batch);
    }

    //添加用户批次
    @RequestMapping("/insertUserBatch")
    @ResponseBody
    public int insertUserBatch(int uid,int batch_id){
        int res = batchService.insertUserBatch(uid, batch_id);
        return res;
    }

}
