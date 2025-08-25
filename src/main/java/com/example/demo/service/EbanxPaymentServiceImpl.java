package com.example.demo.service;

import com.example.demo.domain.EbanxPayment;
import org.springframework.stereotype.Service;

@Service
public class EbanxPaymentServiceImpl {
    public EbanxPayment savePayment(Long subscriptionId,String token){
        EbanxPayment payment = new EbanxPayment();
        payment.setId(1001l);
        payment.setAppId(3);
        payment.setSubscriptionId(subscriptionId);
        payment.setState("pending");
        payment.setToken(token);
        return payment;
    }
}
