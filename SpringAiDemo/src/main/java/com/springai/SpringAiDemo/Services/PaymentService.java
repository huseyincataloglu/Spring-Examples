package com.springai.SpringAiDemo.Services;

import com.springai.SpringAiDemo.exceptions.NotEnoughMoneyException;
import com.springai.SpringAiDemo.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public String performPayment(PaymentDetails paymentDetails){
        return "Payment succeeded : " + paymentDetails.toString();
    }

}
