package com.example.demo;


import com.example.demo.clinet.EbanxApiClient;
import com.example.demo.domain.EbanxPayment;
import com.example.demo.domain.EbanxSubscription;
import com.example.demo.service.EbanxPaymentServiceImpl;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author DaZuiZUi
 *         https://github.com/DaZuiZui
 * DropInApplication
 */
@SpringBootTest
public class DropInApplication {
    private static final Logger log = LoggerFactory.getLogger(DropInApplication.class);

    @Autowired
    private EbanxApiClient ebanxApiClient;
    @Autowired
    private EbanxPaymentServiceImpl ebanxPaymentService;

    @Test
    void start() throws Exception {
        log.info("DropInApplication start");
        //1 User clicks to subscribe
        log.info("User clicks to subscribe");
        EbanxSubscription ebanxSubscription = new EbanxSubscription();
        ebanxSubscription.setUserId(666l);
        ebanxSubscription.setState("pending");
        ebanxSubscription.setCurrentProductId(500501l);
        ebanxSubscription.setId(100l);
        //2 Show Drop-in
        //2.1 get temp token
        String sandboxTmpCardToken = ebanxApiClient.getSandboxTmpCardToken();
        EbanxPayment ebanxPayment = ebanxPaymentService.savePayment(ebanxSubscription.getId(), sandboxTmpCardToken);
        //2.2
        JSONObject jsonObject = ebanxApiClient.chargeWithToken(sandboxTmpCardToken);
        log.info(jsonObject.toString());
        JSONObject payment = jsonObject.getJSONObject("payment");

        String ebanxPaymentId = payment.getString("hash");
        String status = payment.getString("status"); // CO / PE / FA / CA
        String amount = payment.getString("amount_ext");
        String currency = payment.getString("currency_ext");

        JSONObject txnStatus = payment.getJSONObject("transaction_status");
        String authCode = txnStatus.getString("authcode");


        String statusDate = payment.getString("status_date");
        String openDate = payment.getString("open_date");
        String confirmDate = payment.getString("confirm_date");
        String dueDate = payment.getString("due_date");
        String amountBr = payment.getString("amount_br");
        String amountIof = payment.getString("amount_iof");
        String merchantPaymentCode = payment.getString("merchant_payment_code");
        String paymentType = payment.getString("payment_type_code");
        String instalments = payment.getString("instalments");
        boolean captureAvailable = payment.getBoolean("capture_available");
        String billingDescriptor = payment.getJSONObject("details").getString("billing_descriptor");


        if (status.equals("CO")){
            ebanxPayment.setState("success");
            log.info("success............");
        }


        // 取长期 card token
        String cardToken = null;
        if (payment.has("creditcard")) {
            JSONObject creditCard = payment.getJSONObject("creditcard");
            if (creditCard.has("token")) {
                cardToken = creditCard.getString("token");      // 这就是长期 token
            }
        }

        //ebanxPayment.setUpdateAt(Long.valueOf(statusDate));
        ebanxPayment.setAmount(Double.valueOf(amount));
        ebanxPayment.setCurrency(currency);

        ebanxPayment.setEbanxPaymentId(ebanxPaymentId);
        ebanxSubscription.setLatestPaymentId(null);
        ebanxSubscription.setCurrentPeriodStart(1l);
        ebanxSubscription.setCurrentPeriodEnd(5l);
        ebanxSubscription.setCardToken(cardToken);


        log.info("package info:");
        log.info(String.valueOf(ebanxPayment));
        log.info(String.valueOf(ebanxSubscription));


    }



}
