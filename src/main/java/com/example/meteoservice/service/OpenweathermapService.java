package com.example.meteoservice.service;

import com.example.meteoservice.domain.Openweathermap;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class OpenweathermapService {

    @Autowired
    private HTTPService httpService;
    @Autowired
    private Openweathermap openweathermap;


    public void setUrl(String lat, String lon) {
        openweathermap.setUrl(lat, lon);
    }

    public String getResponseBody() {
        httpService.setHttpUrl(openweathermap.getUrl());
        httpService.send();
        return httpService.getResponseBody();
    }

    public String getTemperature() throws JsonProcessingException {
        double result = Double.parseDouble(
                JSONService.getNodeValue(
                        this.getResponseBody(),
                        openweathermap.getPath())) - Openweathermap.getKelvinKoef();
        return String.valueOf((int)result);
    }
}
