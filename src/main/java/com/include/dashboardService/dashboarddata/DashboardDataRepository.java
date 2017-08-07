package com.include.dashboardService.dashboarddata;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DashboardDataRepository extends MongoRepository<DashboardData, Long> {
	
	DashboardData findOneByCode(String code);

}
