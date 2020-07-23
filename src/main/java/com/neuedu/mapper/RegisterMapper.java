package com.neuedu.mapper;

import com.neuedu.pojo.Register;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
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

    int addRegister(Map<String, Object> map);

    List<Register> getRegListByDoc(@Param("state") int state, @Param("docid")int docid);
}