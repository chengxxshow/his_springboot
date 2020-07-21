package com.neuedu.service.impl;

import com.neuedu.mapper.ConstantItemMapper;
import com.neuedu.service.ConstantitemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ConstantitemServiceImpl  implements ConstantitemService {
    @Resource
    private ConstantItemMapper constantItemMapper;
    @Override
    public List<Map<String, Object>> getitemListBytypeCode(String typecode) {
        return constantItemMapper.getitemListBytypeCode(typecode);
    }
}
