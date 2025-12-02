package com.huseyin.Api.restcontrolleradvice;


public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(int id) {
        super("id: " + id + "not valid.");
    }
}
