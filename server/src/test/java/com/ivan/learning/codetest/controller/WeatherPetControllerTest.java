package com.ivan.learning.codetest.controller;

import com.ivan.learning.codetest.service.WeatherPetService;
import com.ivan.learning.codetest.vo.WeatherVO;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherPetControllerTest {
    @Autowired
    private WebApplicationContext context;
    private MockMvc mvc;
    @MockBean
    private WeatherPetService weatherPetService;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void getWeatherInfo() throws Exception {

        WeatherVO weather = new WeatherVO();
        weather.setWeather("Cloud");
        weather.setWind("120");
        weather.setTemperature("23");
        weather.setUpdateTime("2019-08-31 11:00 AM");
        weather.setCity("Dalian");

        Mockito.when(weatherPetService.getWeatherInfo("Dalian")).thenReturn(weather);

        mvc.perform(MockMvcRequestBuilders.get("/api/weather"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Cloud")));
    }
}