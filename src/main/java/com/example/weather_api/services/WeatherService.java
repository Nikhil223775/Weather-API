package com.example.weather_api.services;

import com.example.weather_api.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class WeatherService {

    private final WebClient webClient;

    public WeatherService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Object getWeatherDetails(String latLong){
        Object response =  webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/{latLong}").queryParam("key", Constants.WEATHER_API_KEY).build(latLong))
                .retrieve()
                .bodyToMono(Object.class)
                .block();

//        log.info("Response, {}", response);
        return response;
    }
}
