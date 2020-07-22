package com.neuedu.mapper;

import com.neuedu.pojo.PatientCosts;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;
@Mapper
public interface PatientCostsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PatientCosts record);

    int insertSelective(PatientCosts record);

    PatientCosts selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PatientCosts record);

    int updateByPrimaryKey(PatientCosts record);

    int addPatientCosts(Map<String, Object> pcostMap);
}