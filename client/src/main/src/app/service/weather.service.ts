import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, of} from "rxjs/index";
import {WeatherResp} from "../moudle/weatherresp";

@Injectable({
  providedIn: 'root'
})
export class WeatherService {

  constructor(private http: HttpClient) { }

  private weatherUrl: string = "http://" + location.host + '/api/weather';


  getWeather(city: string): Observable<WeatherResp> {
    console.log(this.weatherUrl);
    return this.http.get<WeatherResp> (this.weatherUrl + "?city=" + city);
  }
}
