package com.example.meteoservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;

@Service
public class JSONService {

    private static ObjectMapper objectMapper = new ObjectMapper();
    @Value("${msga.valid.lng}")
    private static String lng;

    public static boolean isValidLang(String jsonString) throws JsonProcessingException {
        return objectMapper.readTree(jsonString).get("lng").asText().equals(lng);
    }

    public static boolean isEmptyMsg(String jsonString) throws JsonProcessingException {
        String msg = getText(jsonString);
        return msg != null && !msg.isEmpty();
    }

    public static String getText(String jsonString) throws JsonProcessingException {
        return objectMapper.readTree(jsonString).get("msg").asText();
    }

    public static String getNodeValue(String jsonString, String [] path) throws JsonProcessingException {
        JsonNode node = objectMapper.readTree(jsonString);
        for (String arg: path
             ) {
            node = node.get(arg);
        }
        return node.asText();
    }

    public static Object getObject(String jsonString, Class className) throws IOException {
        return objectMapper.readValue(jsonString, className);
    }

    public static String getString(Object object) throws IOException {
        StringWriter writer = new StringWriter();
        objectMapper.writeValue(writer, object);
        return writer.toString();
    }
}
