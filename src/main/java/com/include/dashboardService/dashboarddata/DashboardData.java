package com.include.dashboardService.dashboarddata;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection="DashboardData")
public class DashboardData {
	
	@JsonIgnore
	@Id
	private String id;
	private String code;
	private Object data;
	
	public DashboardData(){
		
	}
	
	public DashboardData(String id, String code, Object data){
		this.id=id;
		this.code=code;
		this.data=data;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

}
