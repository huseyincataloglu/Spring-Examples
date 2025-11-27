package com.example.rest_services2.proxy;

import com.example.rest_services2.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "payments",url = "${name.service.url}") // Implementing rest client
public interface PaymentsProxy {

    @PostMapping("/payment")
    Payment createPayment (
            @RequestHeader String requestId,
            @RequestBody Payment payment);

}
