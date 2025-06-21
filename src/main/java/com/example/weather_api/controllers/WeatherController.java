package com.example.weather_api.controllers;

import com.example.weather_api.services.WeatherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/forecast")
    public Object getWeatherForecast(@RequestParam String latLong){
        return weatherService.getWeatherDetails(latLong);
    }
}
