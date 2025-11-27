package com.example.rest_services2.controller;

import com.example.rest_services2.model.Payment;
import com.example.rest_services2.proxy.PaymentProxyRestTemplate;
import com.example.rest_services2.proxy.PaymentsProxy;
import org.apache.juli.logging.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentController {
    private final Logger logger = Logger.getLogger(PaymentController.class.getName());

//    private final PaymentsProxy paymentsProxy;
    private final PaymentProxyRestTemplate paymentProxyRestTemplate;

    public PaymentController(PaymentProxyRestTemplate paymentProxyRestTemplate){
        this.paymentProxyRestTemplate = paymentProxyRestTemplate;
    }


    @PostMapping("/payment")
    public Payment createPayment(
            @RequestBody Payment payment
    ) {
        return paymentProxyRestTemplate.createPayment(payment);

    }
}
