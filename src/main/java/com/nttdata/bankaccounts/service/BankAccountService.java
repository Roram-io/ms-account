package com.nttdata.bankaccounts.service;

import com.nttdata.bankaccounts.model.BankAccount;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BankAccountService {

    Flux<BankAccount> listBankAccounts();

    Mono<BankAccount> listById(String id);

    Flux<BankAccount> listByHolder(String id);

    Mono<Void> removeBankAccount(String id);

    Mono<BankAccount> saveBankAccount(BankAccount bankAccount);

    Mono<BankAccount> updateBankAccount(BankAccount bankAccount);
}
