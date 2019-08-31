package com.ivan.learning.codetest.controller;

import com.ivan.learning.codetest.dto.OwnerDTO;
import com.ivan.learning.codetest.dto.WeatherDTO;
import com.ivan.learning.codetest.service.WeatherPetService;
import com.ivan.learning.codetest.util.TransferData;
import com.ivan.learning.codetest.vo.WeatherVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/api"})
class WeatherPetController {

    @Resource
    private WeatherPetService weatherPetService;


    @GetMapping("/owner")
    public OwnerDTO[] getOwnerInfo() {
        return this.weatherPetService.getOwnerInfo();
    }

    @GetMapping("/weather")
    public WeatherVO getWeatherInfo(@RequestParam(value = "city", defaultValue = "Dalian") String city) {
        return this.weatherPetService.getWeatherInfo(city);
    }
}