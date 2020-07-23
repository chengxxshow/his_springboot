package com.neuedu.mapper;

import com.neuedu.pojo.MedicalRecord;

public interface MedicalRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MedicalRecord record);

    int insertSelective(MedicalRecord record);

    MedicalRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MedicalRecord record);

    int updateByPrimaryKey(MedicalRecord record);
}