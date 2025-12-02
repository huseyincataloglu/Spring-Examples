package com.huseyin.Api.service;

import com.huseyin.Api.model.Account;
import com.huseyin.Api.repository.AccountRepository;
import com.huseyin.Api.restcontrolleradvice.AccountNotFoundException;
import com.huseyin.Api.restcontrolleradvice.NotEnoughAmountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public Account getAccount(int id){
        return accountRepository.findById(id).orElse(null);
    }

    @Autowired
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }


    public List<Account> listAccounts(String name){
        return accountRepository.findAccountByName(name);
    }


    public List<Account> listAllAcounts(){
        return StreamSupport.stream(accountRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }

    @Transactional
    public void transferMoney(int idSender, int idReceiver, BigDecimal amount) {
        Account sender = accountRepository.findById(idSender).orElseThrow(() -> new AccountNotFoundException(idSender));
        Account receiver = accountRepository.findById(idReceiver).orElseThrow(() -> new AccountNotFoundException(idReceiver));
        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        if(senderNewAmount.compareTo(new BigDecimal(0)) < 0){
            throw new NotEnoughAmountException(idSender);
        }
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);
        sender.setAmount(senderNewAmount);
        receiver.setAmount(receiverNewAmount);
        accountRepository.save(sender);
        accountRepository.save(receiver);
    }


//    @Transactional
//    public void transferMoney(int idSender, int idReceiver, BigDecimal amount){
//        Account sender = accountRepository.findById(idSender).get();
//        Account receiver = accountRepository.findById(idReceiver).get();
//        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
//        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);
//        accountRepository.changeAmount(idSender,senderNewAmount);
//        accountRepository.changeAmount(idReceiver,receiverNewAmount);
//    }


}
