package com.tmousa.availablehotels;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.tmousa.availablehotels.services.available.AvailableHotelsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(FindMeHotel.class)
public class AvailableControllerTest{

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private AvailableHotelsService availableHotelsService;

    @Test
    public void unauthorizedRequest() throws Exception {
        mockMvc.perform(get("/available/availableHotels?city=AMM")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }

    @WithMockUser(username="admin", password ="admin")
    @Test
    public void authorizedRequest() throws Exception {
        when(availableHotelsService.getAvailable(Mockito.any())).thenReturn("");
        mockMvc.perform(get("/available/availableHotels?city=AMM")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}