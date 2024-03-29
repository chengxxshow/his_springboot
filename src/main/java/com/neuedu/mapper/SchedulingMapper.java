package com.neuedu.mapper;

import com.neuedu.pojo.Scheduling;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface SchedulingMapper {
    //查询排班信息
    List<Map<String,Object>> getSchedulingList (@Param("startDate") String startDate, @Param("endDate") String endDate,
                                                @Param("beginRow") int beginRow, @Param("pageSize") int pageSize);
   //查询总个数
   int getSchedulingCount( @Param("startDate") String startDate, @Param("endDate") String endDate);

    int deleteByPrimaryKey(Integer id);

    int insert(Scheduling record);

    int insertSelective(Scheduling record);

    Scheduling selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Scheduling record);

    int updateByPrimaryKey(Scheduling record);


    int addScheduling(Map<String, Object> schdulingMap);

    List<Map<String, Object>> getDeptByVDateAndNoon(@Param("visitDate") String visitDate, @Param("noon") String noon);

    List<Map<String, Object>> getRegLevlByDateNoonDept(Map<String, Object> map);

    List<Map<String, Object>> getDocByDateNoonDeptRegid(Map<String, Object> map);

    Map<String, Object>  getDocRegQuotaByDateNoon(Map<String, Object> map);
}