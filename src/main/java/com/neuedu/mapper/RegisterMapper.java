package com.neuedu.mapper;

import com.neuedu.pojo.Register;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface RegisterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Register record);

    int insertSelective(Register record);

    Register selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Register record);

    int updateByPrimaryKey(Register record);

    String getMaxCaseNumber();

    int getAlreadyRegCount(Map<String, Object> map);
}