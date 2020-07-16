package com.neuedu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.neuedu.service.SchedulingService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



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

}