package com.springai.SpringAiDemo.Services;


import com.springai.SpringAiDemo.model.Payment;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public String performPayment(Payment payment){
        return "Payment Service succeeded";
    }

}
