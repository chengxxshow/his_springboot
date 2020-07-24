package com.neuedu.mapper;

import com.neuedu.pojo.MedicalRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MedicalRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MedicalRecord record);

    int insertSelective(MedicalRecord record);

    MedicalRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MedicalRecord record);

    int updateByPrimaryKey(MedicalRecord record);

    MedicalRecord getMedicalRecordByCaseNum(@Param("casenumber") String casenumber);
}