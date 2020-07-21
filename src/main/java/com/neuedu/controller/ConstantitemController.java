package com.neuedu.controller;

import com.neuedu.service.ConstantitemService;
import com.neuedu.service.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/neusys/contantitem")
public class ConstantitemController {
    @Autowired
    private ConstantitemService constantitemService;


    @RequestMapping("/getitemListBytypeCode")
    public Map<String, Object> getitemListBytypeCode(@RequestParam("typecode") String typecode){
        List<Map<String,Object>> list = constantitemService.getitemListBytypeCode(typecode);
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        return map;
    }

}