package com.neuedu.mapper;

import com.neuedu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    public User getUserBynameandpsw(@Param("uname")String username, @Param("psw")String password);

    User getUserById(@Param("id")int id);
}
