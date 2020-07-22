package com.neuedu.service.impl;

import com.neuedu.mapper.RegisterMapper;
import com.neuedu.service.RegisterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Resource
    private RegisterMapper registerMapper;
    @Override
    public String getMaxCaseNumber() {
        return registerMapper.getMaxCaseNumber();
    }

    @Override
    public int getAlreadyRegCount(Map<String, Object> map) {
        return registerMapper.getAlreadyRegCount(map);
    }
}
