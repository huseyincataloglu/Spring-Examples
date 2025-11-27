package com.springai.SpringAiDemo.controller;


import com.springai.SpringAiDemo.Services.PaymentService;
import com.springai.SpringAiDemo.model.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController // responsebody annotation tells the spring that all the methods of this controller will return data instead of view or view name
public class PaymentController {

    private final Logger logger = Logger.getLogger(PaymentController.class.getName());
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payment")
    public ResponseEntity<?> makePayment(){
        String paymentReturn = paymentService.performPayment(new Payment());
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(paymentReturn);

    } // we have returned only raw string

    @PostMapping("/payment")
    public ResponseEntity<Payment> postPayment(@RequestBody Payment paymentDetail){
        String paymentResult = paymentService.performPayment(paymentDetail);
        logger.info("Payment result :  " + paymentResult);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body (paymentDetail);

    }// we have returnd custom Http response

}
