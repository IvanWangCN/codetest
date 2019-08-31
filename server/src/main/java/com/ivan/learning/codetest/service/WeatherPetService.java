package com.ivan.learning.codetest.service;

import com.ivan.learning.codetest.dto.OwnerDTO;
import com.ivan.learning.codetest.vo.WeatherVO;

public interface WeatherPetService {
    OwnerDTO[] getOwnerInfo();
    WeatherVO getWeatherInfo(String city);
}
