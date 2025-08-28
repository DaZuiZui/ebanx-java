package com.example.demo.ebanx;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/ebanx")
public class EbanxWebhookController {

    // ⚠️ 替换为你的 EBANX API Key，用于校验回调
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

        try {
            // 取出 payment 字段字符串
            String paymentStr = payload.get("payment");
            if (paymentStr == null) {
                return ResponseEntity.badRequest().body("No payment data");
            }

            // 将 payment 字符串解析为 JSONObject
            JSONObject payment = new JSONObject(paymentStr);

            String merchantPaymentCode = payment.optString("merchant_payment_code");
            String status = payment.optString("status"); // PE/CO/CA
            String hash = payment.optString("hash");

            // 校验 hash（根据你的实现）
            if (!validateHash(hash, API_KEY)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid hash");
            }

            // 根据状态更新数据库
            switch (status) {
                case "CO": // Completed
                    updatePaymentState(merchantPaymentCode, "success");
                    updateSubscriptionState(merchantPaymentCode, "active");
                    break;
                case "PE": // Pending
                    updatePaymentState(merchantPaymentCode, "pending");
                    break;
                case "CA": // Canceled
                    updatePaymentState(merchantPaymentCode, "canceled");
                    updateSubscriptionState(merchantPaymentCode, "canceled");
                    break;
                default:
                    System.out.println("Unknown payment status: " + status);
            }

            return ResponseEntity.ok("OK");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    // 模拟数据库更新支付状态
    private void updatePaymentState(String merchantPaymentCode, String state) {
        System.out.println("Update payment " + merchantPaymentCode + " to state " + state);
        // TODO: 替换成真实数据库更新逻辑
    }

    // 模拟数据库更新订阅状态
    private void updateSubscriptionState(String merchantPaymentCode, String state) {
        System.out.println("Update subscription " + merchantPaymentCode + " to state " + state);
        // TODO: 替换成真实数据库更新逻辑
    }

    // 校验 hash（简化示例，可根据 EBANX 官方算法实现 HMAC 校验）
    private boolean validateHash(String hash, String apiKey) {
        return hash != null && !hash.isEmpty();
    }
}
