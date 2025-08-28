package com.example.demo;

import com.example.demo.clinet.EbanxApiClient;
import com.example.demo.service.EbanxPaymentServiceImpl;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PixApplication {
    private static final Logger log = LoggerFactory.getLogger(DropInApplication.class);

    @Autowired
    private EbanxApiClient ebanxApiClient;
    @Autowired
    private EbanxPaymentServiceImpl ebanxPaymentService;

    @Test
    void sayHello() {
        log.info("Hello Dazui");
    }


    @Test
    void pay(){
        ebanxApiClient.getQR(10086137l,5999.00);

    }

}
