package com.example.rest_services2.proxy;

import com.example.rest_services2.model.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;


import java.util.UUID;


@Component
public class PaymentProxyRestTemplate {

    @Value("${name.service.url}")
    private String paymentServiceUrl;
    private final RestTemplate restTemplate;

    public PaymentProxyRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Payment createPayment(Payment payment){
        String uri = paymentServiceUrl + "/payment";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("requestId", UUID.randomUUID().toString());
        HttpEntity httpEntity = new HttpEntity(payment,httpHeaders);

        ResponseEntity<Payment> response = restTemplate.exchange(uri, HttpMethod.POST,httpEntity, Payment.class);
        return response.getBody();
    }


}
