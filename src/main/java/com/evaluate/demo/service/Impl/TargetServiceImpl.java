package com.evaluate.demo.service.Impl;


import com.evaluate.demo.dao.TargetDao;
import com.evaluate.demo.entity.Target;
import com.evaluate.demo.service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TargetServiceImpl implements TargetService {
    @Autowired
    private TargetDao targetDao;

    @Override
    public List<Target> selectTarget() {
        return targetDao.selectTarget();
    }

    @Override
    public List<Target> selectEvaluate() {
        return targetDao.selectEvaluate();
    }

    @Override
    public List<Target> selectFaTarget() {
        return targetDao.selectFaTarget();
    }

    @Override
    public List<Target> selectChildrenTarget() {
        return targetDao.selectChildrenTarget();
    }

    @Override
    public List<Map<String, Object>> getTreeList() {
        List<Target> list = targetDao.selectTarget();
        return buildTree(0,list);
    }

    @Override
    public List<Target> selectTitle(int tid) {
        return targetDao.selectTitle(tid);
    }

    public List<Map<String, Object>> buildTree(Integer tid, List<Target> list){
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        // 1.边界条件
        List<Target> childList = list.stream().filter(item -> item.getFather_targets_id()==tid).collect(Collectors.toList());
        // 3.返回段
        if(childList.isEmpty()) return result;
        // 2.前进段
        childList.stream().forEach(item->{
            Map<String, Object> map = new HashMap<>();
            map.put("targets_id", item.getTargets_id());
            map.put("title", item.getTargets_name());
            map.put("tid", item.getFather_targets_id());
            map.put("href",item.getUrl());
            List<Map<String, Object>> childs = buildTree(item.getTargets_id(), list);
            if(!childs.isEmpty()){
                map.put("children", childs);
            }
            result.add(map);
        });
        return result;
    }


    @Override
    public int updateTarget(Integer tid, String tname,String tweight) {
        return targetDao.updateTarget(tid,tname,tweight);
    }

    @Override
    public int deleteTarget(Integer tid) {
        return targetDao.deleteTarget(tid);
    }

    @Override
    public int insertTarget(Target target) {
        return targetDao.insertTarget(target);
    }

    @Override
    public int insertEvaluateTarget(int evaluates_id, int targets_id) {
        return targetDao.insertEvaluateTarget(evaluates_id, targets_id);
    }


}
