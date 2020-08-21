package com.example.meteoservice.service;

import com.example.meteoservice.domain.MsgA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MsgAService {


    @Autowired
    private HTTPService httpService;
    @Autowired
    private MsgA msgA;

    public String getResponseBody() {
        httpService.setHttpUrl(msgA.getUrl());
        httpService.send();
        return httpService.getResponseBody();
    }

    public MsgA getMsgAMessage() throws IOException {
        String jsonString = getResponseBody();
        MsgA temp = (MsgA) JSONService.getObject(jsonString, MsgA.class);
        msgA.setMsg(temp.getMsg());
        msgA.setLng(temp.getLng());
        msgA.setCoordinate(temp.getCoordinate());
        return msgA;
    }
}