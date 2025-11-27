package com.huseyin.Api.model;

import java.math.BigDecimal;

public class TransferRequest {
    private int senderId;
    private int recevierId;
    private BigDecimal amount;


    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getRecevierId() {
        return recevierId;
    }

    public void setRecevierId(int recevierId) {
        this.recevierId = recevierId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
