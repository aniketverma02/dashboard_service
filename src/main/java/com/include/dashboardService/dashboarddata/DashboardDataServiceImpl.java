package com.include.dashboardService.dashboarddata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardDataServiceImpl implements DashboardDataService {
	
	@Autowired
	DashboardDataRepository dashboardDataRepository;

	@Override
	public DashboardData findOneByCode(String code) {
		
		return dashboardDataRepository.findOneByCode(code);
	}

}
