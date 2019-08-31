package com.ivan.learning.codetest.service;

import com.ivan.learning.codetest.dto.WeatherDTO;
import com.ivan.learning.codetest.util.TransferData;
import com.ivan.learning.codetest.vo.WeatherVO;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherPetServiceImplTests {

    @Autowired
    private WeatherPetServiceImpl weatherPetService;
    @MockBean
    private RestTemplate restTemplate;
    @MockBean
    private TransferData transferData;

    @Before
    public void setUp() {
    }


    @Test
    public void getWeatherInfo() {
        String url = "http://api.openweathermap.org/data/2.5/weather?q={city}&units=imperial&appid={apiKey}";
        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("city", "Dalian");
        uriVariables.put("apiKey", "4573c189d467ca1814c1c10000060792");

        WeatherDTO weather = new WeatherDTO();
        weather.setName("Dalian");

        WeatherVO weatherVO = new WeatherVO();
        weatherVO.setCity("Dalian");
        weatherVO.setTemperature("23");

        Mockito.when(restTemplate.getForObject(url, WeatherDTO.class, uriVariables))
                .thenReturn(weather);
        Mockito.when(transferData.transferWeatherInfo(weather))
                .thenReturn(weatherVO);

        WeatherVO returnData = weatherPetService.getWeatherInfo("Dalian");
        Assertions.assertThat(returnData.getTemperature()).isEqualTo("23");
    }
}
