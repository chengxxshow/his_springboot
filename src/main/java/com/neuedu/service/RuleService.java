package com.neuedu.service;


import com.neuedu.pojo.Rule;

import java.util.List;
import java.util.Map;

public interface RuleService {
    int addRule(Rule rule);

    int getRuleCount(String deptid);

    List<Map<String, Object>> getRuleList(Integer page, Integer count, String deptid);
}
