package com.neuedu.service;

import com.neuedu.pojo.MedicalRecord;

public interface MedicalRecordService {
    int  addMedicalRecord(MedicalRecord record);

    MedicalRecord getMedicalRecordByCaseNum(String casenumber);
}
