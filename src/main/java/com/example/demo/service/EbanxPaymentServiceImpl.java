package com.example.demo.service;

import com.example.demo.domain.EbanxPayment;
import org.springframework.stereotype.Service;

@Service
public class EbanxPaymentServiceImpl {
    public EbanxPayment savePayment(Long subscriptionId,String token){
        EbanxPayment payment = new EbanxPayment();
        payment.setSubscriptionId(subscriptionId);
        payment.setState("pending");
        payment.setToken(token);
        return payment;
    }
}
