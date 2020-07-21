package com.neuedu.service.impl;

import com.neuedu.mapper.SettleCategoryMapper;
import com.neuedu.service.SettleCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class SettleCategoryServiceImpl implements SettleCategoryService {
    @Resource
    private SettleCategoryMapper settleCategoryMapper;
    @Override
    public List<Map<String, Object>> getSettleCategory() {
        return settleCategoryMapper.getSettleCategory();
    }
}
