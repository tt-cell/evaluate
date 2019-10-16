package com.evaluate.demo.service.Impl;
import com.evaluate.demo.dao.OptionDao;
import com.evaluate.demo.entity.Option;
import com.evaluate.demo.entity.TargetOption;
import com.evaluate.demo.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionServiceImpl implements OptionService {
    @Autowired
    private OptionDao optionDao;

    @Override
    public List<Option> selectOption(int tid) {
        return optionDao.selectOption(tid);
    }

    @Override
    public List<Option> selectAllTheOption() {
        return optionDao.selectAllTheOption();
    }

    @Override
    public int updateOption(int oid, String oname) {
        return optionDao.updateOption(oid,oname);
    }

    @Override
    public List<Option> selectAllOption(int tid) {
        return optionDao.selectAllOption(tid);
    }

    @Override
    public int insertOption(TargetOption targetOption) {
        return optionDao.insertOption(targetOption);
    }


}
