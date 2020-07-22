package com.neuedu.service;

import java.util.Map;

public interface RegisterService {
    String getMaxCaseNumber();

    int getAlreadyRegCount(Map<String, Object> map);
}
