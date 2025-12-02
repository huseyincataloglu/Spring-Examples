package com.huseyin.Api;

import com.huseyin.Api.model.Account;
import com.huseyin.Api.repository.AccountRepository;
import com.huseyin.Api.restcontrolleradvice.AccountNotFoundException;
import com.huseyin.Api.restcontrolleradvice.NotEnoughAmountException;
import com.huseyin.Api.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AccountServiceUniteTests {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;


    @Test
    public void moneyTransferHappyFlow(){
        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        Account destination = new Account();
        destination.setId(2);
        destination.setAmount(new BigDecimal(1000));

        when(accountRepository.findById(sender.getId()))
                .thenReturn(Optional.of(sender));

        when(accountRepository.findById(destination.getId()))
                .thenReturn(Optional.of(destination));


        accountService.transferMoney(
                sender.getId(),
                destination.getId(),
                new BigDecimal(100)
        );

        assertEquals(new BigDecimal(900), sender.getAmount());
        assertEquals(new BigDecimal(1100), destination.getAmount());

        verify(accountRepository)
                .save(sender);
        verify(accountRepository)
                .save(destination);


    }

    @Test
    public void testNonExistingAccountException(){

        int nonExistingId = 2;

        Account destination = new Account();
        destination.setId(1);
        destination.setAmount(BigDecimal.valueOf(1000));

        when(accountRepository.findById(nonExistingId)).thenThrow(new AccountNotFoundException(2));

        assertThrows(AccountNotFoundException.class,() ->{
            accountService.transferMoney(
                    nonExistingId,
                    destination.getId(),
                    new BigDecimal(100)
            );
        });
    }

    @Test
    public void testNotEnoughMoneyException(){
        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        Account receiver = new Account();
        receiver.setId(2);
        receiver.setAmount(new BigDecimal(1000));

        when(accountRepository.findById(sender.getId()))
                .thenReturn(Optional.of(sender));

        when(accountRepository.findById(receiver.getId()))
                .thenReturn(Optional.of(receiver));

        assertThrows(NotEnoughAmountException.class,() -> accountService.transferMoney(
                sender.getId(),
                receiver.getId(),
                new BigDecimal(1200)
        ));


    }



}
