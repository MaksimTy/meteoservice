package com.example.meteoservice.controller;

import com.example.meteoservice.service.MsgBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("msgb")
public class MsgBController {

    @Autowired
    private MsgBService msgBService;

    @GetMapping
    public String getMsgb() throws IOException {
        return msgBService.getResponseBody();
    }
}
