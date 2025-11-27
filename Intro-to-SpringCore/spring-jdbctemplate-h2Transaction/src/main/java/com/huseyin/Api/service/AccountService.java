package com.huseyin.Api.service;

import com.huseyin.Api.model.Account;
import com.huseyin.Api.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }


    public List<Account> listAllAcounts(){
        return accountRepository.getAllAcounts();
    }


    @Transactional
    public void transferMoney(int idSender, int idReceiver, BigDecimal amount){
        Account sender = accountRepository.getAccountById(idSender);
        Account receiver = accountRepository.getAccountById(idReceiver);
        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);
        accountRepository.changeAmount(idSender,senderNewAmount);
        accountRepository.changeAmount(idReceiver,receiverNewAmount);
        throw new RuntimeException("oh! Something went wrong");
    }



}
