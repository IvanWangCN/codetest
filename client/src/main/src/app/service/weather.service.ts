import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, of} from "rxjs/index";
import {WeatherResp} from "../moudle/weatherresp";

@Injectable({
  providedIn: 'root'
})
export class WeatherService {

  constructor(private http: HttpClient) { }

  private weatherUrl = 'http://127.0.0.1:8080/api/weather';


  getWeather(city: string): Observable<WeatherResp> {
    return this.http.get<WeatherResp> (this.weatherUrl + "?city=" + city);
  }
}
