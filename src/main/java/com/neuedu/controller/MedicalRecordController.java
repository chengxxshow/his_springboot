package com.neuedu.controller;

import com.neuedu.pojo.MedicalRecord;
import com.neuedu.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/neudoc/medicalrecord")
public class MedicalRecordController {
    @Autowired
    private MedicalRecordService medicalRecordService;
   @RequestMapping("/add")
   public String addMedicalRecord(@RequestBody MedicalRecord mRecord){
       System.out.print("病例信息："+mRecord);
       int i=medicalRecordService.addMedicalRecord(mRecord);
       if(i>0){
           return "病例信息添加成功";
       }else{
           return "病例信息添加失败";
       }

   }
   @RequestMapping("/getMedicalRecordByCaseNum")
    public MedicalRecord getMedicalRecordByCaseNum(@RequestParam("casenumber") String casenumber){
      return medicalRecordService.getMedicalRecordByCaseNum(casenumber);
   }
}
