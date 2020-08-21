package com.example.meteoservice.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Component
@JsonAutoDetect
public class MsgB {

    @Value("${timestamp.pattern}")
    @JsonIgnore
    private String pattern;
    @Value("${timestamp.locale}")
    @JsonIgnore
    private String locale;
    private String txt;
    private String createdDt;
    private String currentTemp;

    public MsgB(String txt, String currentTemp) {
        this.txt = txt;
        this.currentTemp = currentTemp;
        this.setCreatedDt();
    }

    public MsgB() {
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt() {
        this.createdDt = new SimpleDateFormat(
                pattern,
                new Locale(locale)).format(new Date());
    }

    public String getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(String currentTemp) {
        this.currentTemp = currentTemp;
    }

    public String getPattern() {
        return pattern;
    }
}