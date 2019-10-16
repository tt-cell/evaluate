package com.evaluate.demo.service;


import com.evaluate.demo.entity.Option;
import com.evaluate.demo.entity.TargetOption;

import java.util.List;

public interface OptionService {
    List<Option> selectOption(int tid);
    List<Option> selectAllTheOption();
    int updateOption(int oid, String oname);
    List<Option> selectAllOption(int tid);

    int insertOption(int targets_id,int options_id);
}
