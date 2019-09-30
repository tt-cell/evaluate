package com.evaluate.demo.dao;


import com.evaluate.demo.entity.Option;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionDao {
    List<Option> selectOption(int tid);

    int updateOption(int oid, String oname);
    List<Option> selectAllOption(int tid);
}






