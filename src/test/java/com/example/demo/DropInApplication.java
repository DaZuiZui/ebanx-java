package com.example.demo;


import com.example.demo.clinet.EbanxApiClient;
import com.example.demo.domain.EbanxPayment;
import com.example.demo.domain.EbanxSubscription;
import com.example.demo.service.EbanxPaymentServiceImpl;
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
    }



}
