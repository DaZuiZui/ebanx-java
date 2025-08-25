package com.example.demo.config;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * @author DaZuiZui
 * @github https://github.com/DaZuiZui
 */
@Component
public class EbanxApiClient {

    @Value("${ebanx.apiURL}")
    private String API_URL = "";
    @Value("${ebanx.integrationKey}")
    private String API_KEY = "";


    private final HttpClient client;

    public EbanxApiClient() {
        this.client = HttpClient.newHttpClient();
    }

    /**
     * Test the Ebanx API connection status
     * @return JSONObject Returns status information, such as { "status": "ok" } or error information
     */
    public JSONObject testConnection() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(API_URL))
                    .timeout(Duration.ofSeconds(5))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new JSONObject()
                    .put("success", true)
                    .put("statusCode", response.statusCode());
        } catch (Exception e) {
            return new JSONObject()
                    .put("success", false)
                    .put("message", e.getMessage());
        }
    }



}
