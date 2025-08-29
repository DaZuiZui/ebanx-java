package com.example.demo.ebanx;

import com.example.demo.clinet.EbanxApiClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/ebanx")
public class EbanxWebhookController {

    @Autowired
    private EbanxApiClient ebanxApiClient;

    @Value("${ebanx.integrationKey}")
    private  String API_KEY;

    @PostMapping("/hello")
    public String hello() {
        return "Hello ";
    }

    /**
     * 接收 EBANX Pix 回调
     * URL: POST https://your-server.com/ebanx/webhook
     */
    @PostMapping("/webhook")
    public ResponseEntity<String> handleWebhook(@RequestParam Map<String, String> payload) {
        System.err.println("EBANX webhook received: " + payload);
        JSONObject hashCodes = ebanxApiClient.queryPayment(payload.get("hash_codes"));
        System.err.println("EBANX webhook received: " + hashCodes);
        JSONObject jsonObject = hashCodes.getJSONObject("payment");
        String status = jsonObject.getString("status");
        System.err.println(status);


        switch (status) {
            case "CO":
                System.err.println("to do for " + status);
                break;
            case "CA":
                System.err.println("to do for " + status);
                break;
            case "RF":
                System.err.println("to do for " + status);
                break;
        }
        return null;
    }

}
