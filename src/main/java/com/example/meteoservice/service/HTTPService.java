package com.example.meteoservice.service;


import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;


@Service
public class HTTPService {

    private HttpClient httpClient;
    private HttpRequest httpRequest;
    private String httpUrl;
    private HttpResponse<String> httpResponse;

    public HTTPService() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }

    public void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public HttpRequest getHttpRequest() {
        return httpRequest;
    }

    public void setHttpRequest(HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
    }

    public String getHttpUrl() {
        return httpUrl;
    }

    public void setHttpUrl(String httpUrl) {
        this.httpUrl = httpUrl;
    }

    public HttpResponse<String> getHttpResponse() {
        return httpResponse;
    }

    public void setHttpResponse(HttpResponse<String> httpResponse) {
        this.httpResponse = httpResponse;
    }

    public void send() {
        try {
            this.httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(this.httpUrl))
                    .build();
            this.httpResponse = this.httpClient
                    .send(this.httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getResponseBody() {
        return this.httpResponse.body();
    }

    public int getResponseStatusCode() {
        return this.httpResponse.statusCode();
    }

    public Map<String, List<String>> getResponseHeaders() {
        return this.httpResponse.headers().map();
    }
}