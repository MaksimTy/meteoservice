package com.example.meteoservice.controller;

import com.example.meteoservice.service.MsgBService;
import com.example.meteoservice.service.OpenweathermapService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("meteo")
public class MeteoController {

    @Autowired
    private OpenweathermapService openweathermapService;

    @GetMapping("coord")
    public String getResponse(@PathVariable
                              @RequestParam(name = "lat") String lat,
                              @RequestParam(name = "lon") String lon) {
        openweathermapService.setUrl(lat, lon);
        return openweathermapService.getResponseBody();
    }

    @GetMapping("coord/temp")
    public String getTemperature(@PathVariable
                                 @RequestParam(name = "lat") String lat,
                                 @RequestParam(name = "lon") String lon) throws JsonProcessingException {
        openweathermapService.setUrl(lat, lon);
        return openweathermapService.getTemperature();
    }
}
