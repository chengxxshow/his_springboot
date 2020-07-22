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

    @Override
    public int addScheduling(Map<String, Object> schdulingMap) {
        int result=0;
        //1.如何获取指定范围内的所有日期（addStartDate，addEndDate）
           //  获取日期范围转成Date类型
           String addStartDate=(String)schdulingMap.get("addStartDate");
           String addEndDate=(String)schdulingMap.get("addEndDate");
           Date d1,d2;
           try {
               d1 = new SimpleDateFormat("yyyy-MM-dd").parse(addStartDate);
               d2 = new SimpleDateFormat("yyyy-MM-dd").parse(addEndDate);
               Calendar cd1=Calendar.getInstance();
               Calendar cd2=Calendar.getInstance();
               cd1.setTime(d1);//开始日期
               cd2.setTime(d2);
               cd2.add(Calendar.DATE,1);
               d2=cd2.getTime();//结束日期为元结束日期+1天
               //循环将开始日期+1天，判断是否在结束日期之前
               while(cd1.getTime().before(d2)){
                   schdulingMap.put("scheduDate",cd1.getTime());
                   // 2 每一个日期中 午别如何获取（week 111100000000）
                   // 3. 循环插入
                     //判断每一天是星期几
                   int w=dayForWeek(cd1.getTime());
                   //14位的week     下标（上午）=(w-1)*2    下标（下午）=(w-1)*2+1
                   String weeks=(String)schdulingMap.get("weeks");
                   if(weeks.charAt((w-1)*2)=='1'){
                       schdulingMap.put("noon","上午");
                       result=schedulingMapper.addScheduling(schdulingMap);
                   }
                   if(weeks.charAt((w-1)*2+1)=='1'){
                       schdulingMap.put("noon","下午");
                       result=schedulingMapper.addScheduling(schdulingMap);
                   }
                   cd1.add(Calendar.DATE,1);

               }



           }catch (Exception ex){
               System.out.println(ex.getMessage());
           }


        return result;
    }

    @Override
    public List<Map<String, Object>> getDeptByVDateAndNoon(String visitDate, String noon) {
        return schedulingMapper.getDeptByVDateAndNoon(visitDate,noon);
    }

    @Override
    public List<Map<String, Object>> getRegLevlByDateNoonDept(Map<String, Object> map) {
        return schedulingMapper.getRegLevlByDateNoonDept(map);
    }

    @Override
    public List<Map<String, Object>> getDocByDateNoonDeptRegid(Map<String, Object> map) {
        return schedulingMapper.getDocByDateNoonDeptRegid(map);
    }

    @Override
    public Map<String, Object> getDocRegQuotaByDateNoon(Map<String, Object> map) {
        return schedulingMapper.getDocRegQuotaByDateNoon(map);
    }

    //判断当前日期对应的星期数  1 2 3 4 5 6 7
                       //  2 3 4 5 6 7 1
    public int dayForWeek(Date date){
        Calendar c=Calendar.getInstance();
        c.setTime(date);
        int week=0;
        if(  c.get(Calendar.DAY_OF_WEEK)==1){ //星期日
            week=7;
        }else{ //其他星期减1
            week= c.get(Calendar.DAY_OF_WEEK)-1;
        }

        return week;
    }


}