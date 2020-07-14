package com.neuedu.service;


import com.neuedu.pojo.User;

public interface IUserService {

    public User getUserBynameandpsw(String username, String password);

}
