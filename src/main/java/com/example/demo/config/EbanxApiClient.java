package com.example.demo.config;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.UUID;

@Component
public class EbanxApiClient {

    @Value("${ebanx.apiURL}")
    private String API_URL;

    @Value("${ebanx.integrationKey}")
    private String API_KEY;

    private final HttpClient client;

    public EbanxApiClient() {
        this.client = HttpClient.newHttpClient();
    }

    /**
     * Test the Ebanx sandbox API connection and key validity
     * @return JSONObject containing the sandbox response
     */
    public JSONObject testConnection() {
        try {
            // 构建请求体
            JSONObject requestBody = new JSONObject();
            requestBody.put("integration_key", API_KEY);
            requestBody.put("operation", "request");

            // 最小合法 payment 对象
            JSONObject payment = new JSONObject();

            String uuidPart = UUID.randomUUID().toString().replace("-", "").substring(0, 32);
            String merchantCode = "TEST-" + uuidPart; // 总长度 5+32=37 ≤ 40
            payment.put("merchant_payment_code", merchantCode);

            // user info
            // 用户信息
            payment.put("name", "Test User");
            payment.put("email", "test@example.com");
            payment.put("document", "390.533.447-05");

            payment.put("amount_total", 1000);
            payment.put("currency_code", "BRL");
            payment.put("payment_type_code", "creditcard");

            // 最小信用卡信息（沙箱测试卡）
            JSONObject creditCard = new JSONObject();
            creditCard.put("card_number", "5200000000001096");
            creditCard.put("card_name", "Test User");
            creditCard.put("card_due_date", "12/2030");
            creditCard.put("card_cvv", "123");

            payment.put("creditcard", creditCard);
            requestBody.put("payment", payment);

            // 构建 HTTP 请求
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(API_URL))
                    .timeout(Duration.ofSeconds(10))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                    .build();

            // 发送请求
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 返回结果
            return new JSONObject()
                    .put("success", true)
                    .put("statusCode", response.statusCode())
                    .put("body", response.body());

        } catch (Exception e) {
            return new JSONObject()
                    .put("success", false)
                    .put("message", e.getMessage());
        }
    }
}
