package com.neuedu.controller;

import com.neuedu.service.ConstantitemService;
import com.neuedu.service.SchedulingService;
import com.neuedu.service.SettleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/neusys/settleCategory")
public class SettleCategoryController {
    @Autowired
    private SettleCategoryService settleCategoryService;


    @RequestMapping("/all")
    public Map<String, Object> getSettleCategory(){
        List<Map<String,Object>> list = settleCategoryService.getSettleCategory();
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        return map;
    }

}