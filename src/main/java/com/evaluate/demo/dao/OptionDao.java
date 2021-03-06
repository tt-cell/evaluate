package com.evaluate.demo.dao;


import com.evaluate.demo.entity.Option;

import com.evaluate.demo.entity.TargetOption;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionDao {
    List<Option> selectOption(int tid);
    List<Option> selectAllTheOption();
    int updateOption(int oid, String oname);
    List<Option> selectAllOption(int tid);

    int insertOption(int targets_id,int options_id);
}






