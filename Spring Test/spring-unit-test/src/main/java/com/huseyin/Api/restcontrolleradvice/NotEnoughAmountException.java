package com.huseyin.Api.restcontrolleradvice;

import java.math.BigDecimal;

public class NotEnoughAmountException extends RuntimeException {
    public NotEnoughAmountException(int id) {
        super("id:" + id + "doesnt have enough money for operation");
    }
}
