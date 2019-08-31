package com.ivan.learning.codetest.util;

import com.ivan.learning.codetest.dto.OwnerDTO;
import com.ivan.learning.codetest.dto.WeatherDTO;
import com.ivan.learning.codetest.vo.OwnerVO;
import com.ivan.learning.codetest.vo.WeatherVO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class TransferData {
    @Resource
    private WeatherVO weatherVO;
    @Resource
    private OwnerVO ownerVO;

    public OwnerVO transferOwnerInfo(OwnerDTO[] ownerDTO) {
        return null;
    }

    public WeatherVO transferWeatherInfo(WeatherDTO weatherDTO) {
        // Set City
        this.weatherVO.setCity(weatherDTO.getName());
        // Set Update Time
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd E hh:mm a");
        String sd = sdf.format(new Date(new Long(String.valueOf(weatherDTO.getDt())) * 1000));
        this.weatherVO.setUpdateTime(sd);
        // Set Weather
        this.weatherVO.setWeather(weatherDTO.getWeather().get(0).getDescription());
        // Set Temperature
        Double fahrenehit = weatherDTO.getMain().getTemp();
        int celsius= (int)((fahrenehit - 32) * ( 5.0 / 9 ));
        this.weatherVO.setTemperature(String.valueOf(celsius));
        // Set Wind
        this.weatherVO.setWind(String.valueOf(weatherDTO.getWind().getSpeed()));

        return this.weatherVO;
    }
}
