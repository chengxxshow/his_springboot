package com.neuedu.service;

import java.util.List;
import java.util.Map;

public interface SchedulingService {
    

	List<Map<String, Object>> getSchedulingList(Integer page, Integer count, String keywords, String keywords2);


	int getSchedulingCount(String starDate, String endDate);
}