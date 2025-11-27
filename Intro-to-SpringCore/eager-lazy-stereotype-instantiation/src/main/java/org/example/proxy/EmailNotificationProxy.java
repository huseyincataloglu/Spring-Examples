package org.example.proxy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class EmailNotificationProxy implements AnimalStoreProxy {
    public EmailNotificationProxy(){
        System.out.println("Emailproxt is created");
    }
    @Override
    public void sendPurchaseNotification(String purchase) {
        System.out.println("Email has been send for your purchase : %s".formatted(purchase));
    }
}
