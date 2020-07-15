package com.neuedu.service.impl;


import com.neuedu.mapper.UserMapper;
import com.neuedu.pojo.User;
import com.neuedu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserServiceImpl implements IUserService {
   @Resource
  // @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserBynameandpsw(String username, String password) {
        System.out.println("222"+userMapper);
        return userMapper.getUserBynameandpsw(username,password);
    }

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }


}
