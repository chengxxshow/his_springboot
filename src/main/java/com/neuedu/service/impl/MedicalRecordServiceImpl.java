package com.neuedu.service.impl;

import com.neuedu.mapper.MedicalRecordMapper;
import com.neuedu.mapper.RegisterMapper;
import com.neuedu.pojo.MedicalRecord;
import com.neuedu.pojo.Register;
import com.neuedu.service.MedicalRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {
    @Resource
    private MedicalRecordMapper medicalRecordMapper;
    @Resource
    private RegisterMapper registerMapper;
    @Override
    //添加病例信息
    public int addMedicalRecord(MedicalRecord record) {
        int res=0;
        //判断当前病例号的病例信息是否存在，存在 修改，不存在 添加
        MedicalRecord obj=medicalRecordMapper.getMedicalRecordByCaseNum(record.getCasenumber());
       if(obj!=null){
           //修改
           res=medicalRecordMapper.updateByPrimaryKeySelective(obj);
       }else{
           //添加
          res= medicalRecordMapper.insertSelective(record);
       }
        //病例信息已提交，需要修改挂号表的当前患者的看诊状态为2（医生已接诊）
        if(record.getCasestate()==2){
            //根据挂号id查询患者挂号对象
             Register regobj=registerMapper.selectByPrimaryKey(record.getRegistid());
             regobj.setVisitstate(2);
            registerMapper.updateByPrimaryKeySelective(regobj);
        }
        return res;
    }

    @Override
    public MedicalRecord getMedicalRecordByCaseNum(String casenumber) {
        return medicalRecordMapper.getMedicalRecordByCaseNum(casenumber);
    }
}
