package com.example.meteoservice.domain;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@JsonAutoDetect
public class MsgA {
    @JsonIgnore
    @Value("${msga.url_template}")
    private String url;

    private String msg;
    private LngType lng;
    private Coordinate coordinate;

    public MsgA(String msg, LngType lng, Coordinate coordinate) {
        this.msg = msg;
        this.lng = lng;
        this.coordinate = coordinate;
    }

    public MsgA() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public LngType getLng() {
        return lng;
    }

    public void setLng(LngType lng) {
        this.lng = lng;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public String getUrl() {
        return url;
    }

    public String getLatitude() {
        return this.coordinate.latitude;
    }

    public String getLongitude() {
        return this.coordinate.longitude;
    }


    @JsonAutoDetect
    public class Coordinate {

        private String latitude;
        private String longitude;

        public Coordinate(String latitude, String longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public Coordinate() {
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }
    }

    @JsonAutoDetect
    private enum LngType {
        ru,
        en,
        es;
    }

}