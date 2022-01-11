package com.nttdata.bankaccounts.service.impl;

import com.nttdata.bankaccounts.model.BankAccount;
import com.nttdata.bankaccounts.repository.BankAccountRepository;
import com.nttdata.bankaccounts.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Override
    public Flux<BankAccount> listBankAccounts() {
        return null;
    }

    @Override
    public Mono<BankAccount> listByHolder(String id){
        return null;
    }

    @Override
    public Mono<BankAccount> listById(String id) {
        return null;
    }

    @Override
    public Mono<Void> removeBankAccount(String id) {
        return null;
    }

    @Override
    public Mono<BankAccount> saveBankAccount(BankAccount bankAccount) {
        return null;
    }

    @Override
    public Mono<BankAccount> updateBankAccount(BankAccount bankAccount) {
        return null;
    }
}
