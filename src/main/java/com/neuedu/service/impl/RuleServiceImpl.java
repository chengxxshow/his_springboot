package com.neuedu.service.impl;

import com.neuedu.mapper.RuleMapper;
import com.neuedu.pojo.Rule;
import com.neuedu.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class RuleServiceImpl implements RuleService {
    @Resource
   // @Autowired
    private RuleMapper ruleMapper;
    public int addRule(Rule rule) {
        return ruleMapper.insertSelective(rule);
    }

    @Override
    public int getRuleCount(String deptid) {

        return ruleMapper.getRuleCount(deptid);
    }

    @Override
    public List<Map<String, Object>> getRuleList(Integer page, Integer count, String deptid) {
        int start = (page - 1) * count;
        return ruleMapper.getRuleList(start,count,deptid);
    }
}
