package com.neuedu.mapper;

import com.neuedu.pojo.Rule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface RuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Rule record);

    int insertSelective(Rule record);

    Rule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Rule record);

    int updateByPrimaryKey(Rule record);

    int getRuleCount(@Param("deptid") String deptid);

    List<Map<String, Object>> getRuleList(@Param("start") int start, @Param("count") Integer count, @Param("deptid") String deptid);
}