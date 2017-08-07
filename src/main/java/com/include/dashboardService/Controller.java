/**
 * 
 */
package com.include.dashboardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.include.dashboardService.dashboarddata.DashboardDataServiceImpl;


/**
 * @author tf
 *
 */
@RestController
@RequestMapping("/api/{version}/data")
public class Controller {
	
	@Autowired
	DashboardDataServiceImpl dashboardDataService;

	@RequestMapping("/test")
    public String test(@RequestParam(value="name", defaultValue="Wo") String name) {
        return name;
    }
	
	@RequestMapping("/getData")
    public ApiResponse getData(@RequestParam(value="code", defaultValue="1") String code) {
		ApiResponse response = new ApiResponse();
		try{
		response.setData(dashboardDataService.findOneByCode(code));
		response.setMsg("success");
		response.setStatus(200);
		}
		catch(Exception e){
			response.setMsg(e.getMessage());
			response.setStatus(500);
		}
		return response;
    }
	
}
