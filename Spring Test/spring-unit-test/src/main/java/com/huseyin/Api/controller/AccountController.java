package com.huseyin.Api.controller;

import com.huseyin.Api.model.Account;
import com.huseyin.Api.model.TransferRequest;
import com.huseyin.Api.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/accounts")
    public List<Account> getAccounts(
            @RequestParam(required = false) String name
    ){
        if(name == null){
            return accountService.listAllAcounts();
        }
        else{
            return accountService.listAccounts(name);
        }

    }



}
