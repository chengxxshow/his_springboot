package com.neuedu.service.impl;

import com.neuedu.mapper.RegisterMapper;
import com.neuedu.service.RegisterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Resource
    private RegisterMapper registerMapper;
    @Override
    public String getMaxCaseNumber() {
        return registerMapper.getMaxCaseNumber();
    }
}
