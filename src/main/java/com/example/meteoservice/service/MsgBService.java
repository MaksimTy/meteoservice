package com.example.meteoservice.service;

import com.example.meteoservice.domain.MsgA;
import com.example.meteoservice.domain.MsgB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MsgBService {

    @Autowired
    private MsgB msgB;
    @Autowired
    private OpenweathermapService openweathermapService;
    @Autowired
    private MsgAService msgAService;

    public String getResponseBody() throws IOException {
        setMsgB();
        return JSONService.getString(this.msgB);
    }

    public MsgB getMsgB() {
        this.setMsgB();
        return this.msgB;
    }

    private void setMsgB() {
        try {
            MsgA a = msgAService.getMsgAMessage();
            String txt = a.getMsg();
            String lat = a.getLatitude();
            String lon = a.getLongitude();
            openweathermapService.setUrl(lat, lon);
            String temp = openweathermapService.getTemperature();

            this.msgB.setTxt(txt);
            this.msgB.setCurrentTemp(temp);
            this.msgB.setCreatedDt();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
