package com.evaluate.demo.service;


import com.evaluate.demo.entity.Option;

import java.util.List;

public interface OptionService {
    List<Option> selectOption(int tid);

    int updateOption(int oid, String oname);
    List<Option> selectAllOption(int tid);
}
