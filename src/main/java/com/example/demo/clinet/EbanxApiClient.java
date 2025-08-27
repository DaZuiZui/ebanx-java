package com.example.demo.clinet;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(EbanxApiClient.class);
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
            JSONObject requestBody = new JSONObject();
            requestBody.put("integration_key", API_KEY);
            requestBody.put("operation", "request");

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

            // card info
            JSONObject creditCard = new JSONObject();
            creditCard.put("card_number", "5200000000001096");
            creditCard.put("card_name", "Test User");
            creditCard.put("card_due_date", "12/2030");
            creditCard.put("card_cvv", "123");

            payment.put("creditcard", creditCard);
            requestBody.put("payment", payment);

            //  send http req
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(API_URL))
                    .timeout(Duration.ofSeconds(10))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // ress
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

    /**
     * getSandboxTmpCardToken
     * @return
     * @throws Exception
     */
    public String getSandboxTmpCardToken() throws Exception {
        String url = "https://sandbox.ebanxpay.com/ws/token";

        JSONObject requestBody = new JSONObject();
        requestBody.put("integration_key", API_KEY);

        JSONObject creditCard = new JSONObject();
        creditCard.put("card_number", "5200000000001096"); // 沙箱测试卡
        creditCard.put("card_name", "Test User");
        creditCard.put("card_due_date", "12/2030");
        creditCard.put("card_cvv", "123");

        requestBody.put("creditcard", creditCard);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject json = new JSONObject(response.body());
        return json.getString("token"); // EBANX 返回的临时 token
    }


    public JSONObject chargeWithToken(String token, Double amount) {
        try {
            String url = "https://sandbox.ebanxpay.com/ws/direct";

            JSONObject requestBody = new JSONObject();
            requestBody.put("integration_key", API_KEY);
            requestBody.put("operation", "request");

            JSONObject payment = new JSONObject();
            payment.put("name", "Test User");
            payment.put("email", "test@example.com");
            payment.put("document", "39053344705"); // 沙箱 CPF
            payment.put("merchant_payment_code", UUID.randomUUID().toString());
            payment.put("amount_total", amount);   // 使用方法参数
            payment.put("currency_code", "BRL");
            payment.put("payment_type_code", "creditcard");

            // creditcard 对象
            JSONObject creditcard = new JSONObject();
            creditcard.put("token", token);      // 临时 token
            creditcard.put("cvv", "123");        // CVV 必须传
            creditcard.put("save_card", true);   // 设置保存信用卡
            payment.put("creditcard", creditcard);

            requestBody.put("payment", payment);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            log.info("Charge response: {}", response.body());

            JSONObject jsonResponse = new JSONObject(response.body());

            // 提取长期 token（如果支付成功）
            if (jsonResponse.optBoolean("success")) {
                JSONObject paymentResult = jsonResponse.getJSONObject("payment");
                if (paymentResult.has("creditcard")) {
                    JSONObject ccResult = paymentResult.getJSONObject("creditcard");
                    if (ccResult.has("token")) {
                        String longTermToken = ccResult.getString("token");
                        jsonResponse.put("long_term_token", longTermToken);
                    }
                }
            }

            return jsonResponse;

        } catch (Exception e) {
            return new JSONObject().put("success", false).put("message", e.getMessage());
        }
    }



}
