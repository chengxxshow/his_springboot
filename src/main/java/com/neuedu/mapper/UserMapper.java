package com.neuedu.mapper;

import com.neuedu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User getUserBynameandpsw(@Param("uname") String username,@Param("psw")String password);
    User getUserById(@Param("id") int id);
}