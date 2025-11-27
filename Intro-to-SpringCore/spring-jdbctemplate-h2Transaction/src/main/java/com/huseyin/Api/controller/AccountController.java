package com.huseyin.Api.controller;

import com.huseyin.Api.model.Account;
import com.huseyin.Api.model.TransferRequest;
import com.huseyin.Api.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping("/transfer")
    public void transfer(
            @RequestBody TransferRequest transferRequest
    ){
        accountService.transferMoney(
                transferRequest.getSenderId(),
                transferRequest.getRecevierId(),
                transferRequest.getAmount()
        );
    }

    @GetMapping("allAcounts")
    public List<Account> listAllAcounts(){
        return accountService.listAllAcounts();
    }



}
