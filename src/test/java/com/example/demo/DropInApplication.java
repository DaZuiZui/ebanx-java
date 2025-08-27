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
        ebanxSubscription.setAmount(100.00);
        //2 Show Drop-in
        //2.1 get temp token
        String sandboxTmpCardToken = ebanxApiClient.getSandboxTmpCardToken();
        EbanxPayment ebanxPayment = ebanxPaymentService.savePayment(ebanxSubscription.getId(), sandboxTmpCardToken);
        ebanxSubscription.setLatestPaymentId(ebanxPayment.getId());
        //2.2
        JSONObject jsonObject = ebanxApiClient.chargeWithToken(sandboxTmpCardToken, ebanxSubscription.getAmount());
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



        //ebanxPayment.setUpdateAt(Long.valueOf(statusDate));
        ebanxPayment.setAmount(Double.valueOf(amount));
        ebanxPayment.setCurrency(currency);

        ebanxPayment.setEbanxPaymentId(ebanxPaymentId);
        ebanxSubscription.setLatestPaymentId(null);
        ebanxSubscription.setCurrentPeriodStart(1l);
        ebanxSubscription.setCurrentPeriodEnd(5l);
        ebanxSubscription.setCardToken(sandboxTmpCardToken);
        ebanxSubscription.setState("active");

        log.info("package info:");
        log.info(String.valueOf(ebanxPayment));
        log.info(String.valueOf(ebanxSubscription));

        log.info("Next cycle:");
//        this.nextCycle(sandboxTmpCardToken,ebanxSubscription);
        JSONObject jsonObject1 = ebanxApiClient.chargeWithToken(sandboxTmpCardToken, ebanxSubscription.getAmount());
        log.info(jsonObject1.toString());
    }
//
//
//    /**
//     * 下一周期扣费
//     * next cycle
//     *             我在工位很想家
//     */
//    void nextCycle(String token,EbanxSubscription subscription ) {
//        log.info("start next cycle:");
//
//
//
//        EbanxPayment payment1 = new EbanxPayment();
//        payment1.setId(10002l);
//        payment1.setSubscriptionId(subscription.getId());
//        payment1.setUserId(subscription.getUserId());
//        payment1.setAmount(subscription.getAmount()); // 当前周期费用
//        payment1.setCurrency("BRL");
//        payment1.setState("pending");
//        payment1.setPaymentMethod("card");
//        payment1.setToken(subscription.getCardToken()); // 长期 token
//
//        log.info("save payment");
//
//        EbanxSubscription subscription1 = new EbanxSubscription();
//        subscription1.setUserId(subscription.getUserId());
//        subscription1.setAmount(subscription.getAmount());
//        subscription1.setCurrency("BRL");
//        subscription1.setState("pending");
//        subscription1.setLatestPaymentId(payment1.getId());
//        subscription1.setCurrentPeriodStart(5l);
//        subscription1.setCurrentPeriodEnd(15l);
//        subscription1.setCardToken(subscription.getCardToken());
//        subscription1.setId(100011l);
//
//        JSONObject jsonObject = ebanxApiClient.chargeWithLongTermToken(subscription.getCardToken(), subscription.getAmount(),subscription1.getId());
//        log.info(jsonObject.toString());
//
//
//    }

}
