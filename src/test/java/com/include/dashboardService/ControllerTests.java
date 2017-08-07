package com.include.dashboardService;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.include.dashboardService.dashboarddata.DashboardData;
import com.include.dashboardService.dashboarddata.DashboardDataService;
import com.include.dashboardService.dashboarddata.DashboardDataServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(Controller.class)
public class ControllerTests {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	DashboardDataService dashboardDataService;

	@MockBean
	DashboardDataServiceImpl dashboardDataServiceImpl;

    @Test
    public void testDashboardDataServiceWithCode() throws Exception {
        given(this.dashboardDataService.findOneByCode("1"))
                .willReturn(new DashboardData("1", "1", new Object()));
        
        this.mockMvc.perform(get("/api/v1/data/getData?code=1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("$.msg").value("success"));
    }
    
    @Test
    public void testDashboardDataServiceForWrongCode() throws Exception {
        given(this.dashboardDataService.findOneByCode("WrongCode"))
                .willReturn(null);
        
        this.mockMvc.perform(get("/api/v1/data/getData").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("$.data").isEmpty());
    }
    
}
