package com.neuedu.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.neuedu.service.SchedulingService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.neuedu.mapper.SchedulingMapper;

import javax.annotation.Resource;


@Service
public class SchedulingServiceImpl implements SchedulingService {
    @Resource
    SchedulingMapper schedulingMapper;
    
    /** 
     * 按条件分页查询排班的方法   
     * @param: page当前页   count每页显示记录数量   keywords keywords2 查询关键字
     * @return: 包含查询结果的Map集合
     */  
    public List<Map<String,Object>> getSchedulingList( Integer page, Integer count,String keywords,String keywords2) {
         int start = (page - 1) * count;
         return schedulingMapper.getSchedulingList(keywords ,keywords2,start, count);
    }

    @Override
    public int getSchedulingCount( String keywords, String keywords2) {
        return schedulingMapper.getSchedulingCount(keywords, keywords2);
    }


}