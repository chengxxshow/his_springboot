package com.neuedu.service;

import java.util.List;
import java.util.Map;

public interface SchedulingService {
    

	List<Map<String, Object>> getSchedulingList(Integer page, Integer count, String keywords, String keywords2);


	int getSchedulingCount(String starDate, String endDate);

    int addScheduling(Map<String, Object> schdulingMap);

    List<Map<String, Object>> getDeptByVDateAndNoon(String visitDate, String noon);
}