package com.evaluate.demo.service.Impl;

import com.evaluate.demo.dao.FunctionDao;
import com.evaluate.demo.entity.Function;
import com.evaluate.demo.entity.SonFunction;
import com.evaluate.demo.entity.User;
import com.evaluate.demo.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FunctionServiceImpl implements FunctionService {
    @Autowired
    private FunctionDao functionDao;

    @Override
    public List<User> selectUserName(String uname) {
        return functionDao.selectUserName(uname);
    }

    @Override
    public List<Map<String, Object>> getTreeList(Integer fid,String rid) {
        List<Function> list = functionDao.getTreeLists(rid);
        return buildTree(fid, list);
    }

    public List<Map<String, Object>> buildTree(Integer pid, List<Function> list){
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        // 1.边界条件
        List<Function> childList = list.stream().filter(item -> item.getFather_id()==pid).collect(Collectors.toList());
        // 3.返回段
        if(childList.isEmpty()) return result;

        // 2.前进段
        childList.stream().forEach(item->{
            Map<String, Object> map = new HashMap<>();
            map.put("fid", item.getFid());
            map.put("title", item.getFname());
            map.put("pid", item.getFather_id());
            map.put("href", item.getUrl());
            map.put("status", item.getStatus());

            List<Map<String, Object>> childs = buildTree(item.getFid(), list);
            if(!childs.isEmpty()){
                map.put("children", childs);
            }
            result.add(map);
        });
        return result;
    }


    @Override
    public List<Function> selectAllFunction(String uid) {
        return functionDao.selectAllFunction(uid);
    }

    @Override
    public String selectRnameToUid(String uid) {
        return functionDao.selectRnameToUid(uid);
    }

    @Override
    public List<SonFunction> selectSonFunction(String uid) {
        return functionDao.selectSonFunction(uid);
    }
}
