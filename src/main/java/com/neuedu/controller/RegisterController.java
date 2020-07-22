package com.neuedu.controller;

import com.neuedu.pojo.User;
import com.neuedu.service.InvoiceService;
import com.neuedu.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/neughsf/register")
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    //获取最新病历号
    @RequestMapping("/getMaxCaseNumber")
    public Map<String ,String> getMaxCaseNumber()
    {
        Map<String,String > map=new HashMap<String ,String>();
         map.put("casenumber",registerService.getMaxCaseNumber());
        return map;
    }
    @RequestMapping("/getAlreadyRegCount")
    public int getAlreadyRegCount(@RequestBody Map<String ,Object> map){
       return registerService.getAlreadyRegCount(map);
    }
    //挂号
    @RequestMapping("/addRegister")
    public Map<String ,Object> addRegister(@RequestBody Map<String ,Object> map,HttpSession session){
        User user=(User) session.getAttribute("userInfo");
        if(user!=null){
            map.put("RegisterID",user.getId());
        }
        Map<String,Object > rmap=new HashMap<String,Object >();
        int res=registerService.addRegister(map);
        if(res>0){
            rmap.put("msg","挂号成功！");
        }else{
            rmap.put("msg","挂号失败！");
        }
        return rmap;
    }
}
