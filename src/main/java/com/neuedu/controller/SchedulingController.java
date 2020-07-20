package com.neuedu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.neuedu.service.SchedulingService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/neusys/scheduling")
public class SchedulingController {
    @Autowired
    private SchedulingService schedulingService;

    /** 
     * 按条件分页查询排班的方法   
     * @param: page当前页   count每页显示记录数量   keywords keywords2 查询关键字
     * @return: 包含查询结果的Map集合
     */  
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Map<String, Object> getSchedulingList( @RequestParam(value = "page", defaultValue = "1") Integer page, 
    		@RequestParam(value = "count", defaultValue = "10") Integer count,@RequestParam("startDate") String startDate,@RequestParam("endDate") String endDate) {
        int totalCount = schedulingService.getSchedulingCount(startDate,endDate);
        List<Map<String,Object>> list = schedulingService.getSchedulingList(page,count,startDate,endDate);
        Map<String, Object> map = new HashMap<>();
        map.put("totalCount", totalCount);//totalCount  10
        map.put("list", list);
        
        return map;
    }
    //生成排班计划
    @RequestMapping("/add")
    public Map<String,Object>  addScheduling(@RequestBody Map<String,Object> schdulingMap){
        System.out.println("生成排班计划对象："+schdulingMap);
        Map<String ,Object> map=new HashMap<String,Object>();
        int i=schedulingService.addScheduling(schdulingMap);
        if(i>0){
            map.put("msg","排班计划添加成功！");
            map.put("status",200);
        }else{
            map.put("msg","排班计划添加失败！");
            map.put("status",403);
        }
        return map;
    }

}