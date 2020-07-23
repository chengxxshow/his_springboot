package com.neuedu.service;

import com.neuedu.pojo.Register;

import java.util.List;
import java.util.Map;

public interface RegisterService {
    String getMaxCaseNumber();

    int getAlreadyRegCount(Map<String, Object> map);

    int addRegister(Map<String, Object> map);

    List<Register>  getRegListByDoc(int state, int docid);
}
