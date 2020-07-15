package com.neuedu.controller;

import com.neuedu.pojo.User;
import com.neuedu.service.IUserService;
import com.neuedu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public User login(@RequestBody User lUser, HttpSession session){
        System.out.println("111"+userService);
        System.out.println(lUser+"---come from front----");
        User user=userService.getUserBynameandpsw(lUser.getUsername(),lUser.getPassword());
        System.out.println(user+"---back to front----");
        // success login in  store current user to session
        if(user!=null){
            session.setAttribute("userInfo",user);
        }
        return user;
    }

    @RequestMapping("/logOut")
    @ResponseBody
    public void logOut(HttpSession session){
        session.invalidate();
    }

    @RequestMapping("/getUserById")
    @ResponseBody
    public User getUserById(@RequestParam int id){
        System.out.println("ID:"+id);
        return userService.getUserById(id);
    }
}