package com.neuedu.controller;

import com.neuedu.pojo.Rule;
import com.neuedu.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/neusys/rule")
public class RuleController {
    @Autowired
    private RuleService ruleService;
    @RequestMapping("/addRule")
    public Map<String,String> addRule(@RequestBody Rule rule){
        System.out.println(rule);
       Map<String,String> map=new HashMap<String,String>();
        int i=ruleService.addRule(rule);
        if(i>0){
            map.put("msg","添加成功");
        }
       return map;
    }
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Map<String, Object> getRuleList( @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                  @RequestParam(value = "count", defaultValue = "10") Integer count,@RequestParam("deptID") String deptid) {
        int totalCount = ruleService.getRuleCount(deptid);
        List<Map<String,Object>> list = ruleService.getRuleList(page,count,deptid);
        Map<String, Object> map = new HashMap<>();
        map.put("totalCount", totalCount);//totalCount  10
        map.put("list", list);

        return map;
    }

}
