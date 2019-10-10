package com.evaluate.demo.controller;

import com.evaluate.demo.entity.EvaluateResult;
import com.evaluate.demo.service.EvaluateResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EvaluateResultController {
    @Autowired
    private EvaluateResultService evaluateResultService;

    @RequestMapping(value = "/insertEvaluateResult")
    @ResponseBody
    public int insertEvaluateResult(EvaluateResult evaluateResult){
        int res = evaluateResultService.insertEvaluateResult(evaluateResult);
        if(res>0)
            return res;
        else
            return 0;
    }
}
