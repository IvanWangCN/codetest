package com.ivan.learning.codetest.service;

import com.ivan.learning.codetest.dto.OwnerDTO;
import com.ivan.learning.codetest.dto.WeatherDTO;
import com.ivan.learning.codetest.util.TransferData;
import com.ivan.learning.codetest.vo.WeatherVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherPetServiceImpl implements WeatherPetService{

    @Resource
    RestTemplate restTemplate;
    @Resource
    private TransferData transferData;

    @Value("${owner.url}")
    private String ownerSrvUrl;

    @Value("${weather.url}")
    private String weatherSrvUrl;

    @Value("${weather.apikey}")
    private String weatherApiKey;


    @Override
    public OwnerDTO[] getOwnerInfo() {
        OwnerDTO[] owner = restTemplate.getForObject(this.ownerSrvUrl, OwnerDTO[].class);
        return owner;
    }

    @Override
    public WeatherVO getWeatherInfo(String city) {
        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("city", city);
        uriVariables.put("apiKey", this.weatherApiKey);

        WeatherDTO weather = restTemplate.getForObject(this.weatherSrvUrl, WeatherDTO.class, uriVariables);
        return transferData.transferWeatherInfo(weather);
    }
}
