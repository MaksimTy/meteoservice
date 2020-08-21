package com.example.meteoservice.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Openweathermap {

    @Value("${openweathermap.url_template}")
    private String urlTemplate;
    @Value("${openweathermap.token}")
    private String apiToken;
    @Value("${openweathermap.temperature.path}")
    private String [] path;
    private static double KELVIN_KOEF = 273.15;
    private String url;
    private String lat;
    private String lon;

    public Openweathermap() {
    }

    public String getUrlTemplate() {
        return urlTemplate;
    }

    public void setUrlTemplate(String urlTemplate) {
        this.urlTemplate = urlTemplate;
    }

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String lat, String lon) {
        this.lat = lat;
        this.lon = lon;
        this.url = String.format(this.urlTemplate, lat, lon, this.apiToken);
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public String[] getPath() {
        return path;
    }

    public static double getKelvinKoef() {
        return KELVIN_KOEF;
    }
}
