import { Component, OnInit } from '@angular/core';
import {WeatherService} from "../service/weather.service";
import {WeatherResp} from "../moudle/weatherresp";

@Component({
  selector: 'app-weather',
  templateUrl: './weather.component.html',
  styleUrls: ['./weather.component.css']
})
export class WeatherComponent implements OnInit {

  constructor(private weatherService: WeatherService) { }

  wr: WeatherResp;
  cities: string[] = ["Sydney", "Melbourne", "Wollongong"];

  ngOnInit() {
    this.getWeatherInfo("Sydney");
  }

  getWeatherInfo(city: string): void {
    this.weatherService.getWeather(city).subscribe(
      result => {
        this.wr = result;
        console.dir(this.wr);

      }
    );
  }

}
