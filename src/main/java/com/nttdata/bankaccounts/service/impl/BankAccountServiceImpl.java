package com.nttdata.bankaccounts.service.impl;

import com.nttdata.bankaccounts.model.BankAccount;
import com.nttdata.bankaccounts.repository.BankAccountRepository;
import com.nttdata.bankaccounts.service.BankAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    Logger log = LoggerFactory.getLogger(BankAccountServiceImpl.class);

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Override
    public Flux<BankAccount> listBankAccounts() {
        log.info("Calling repository for Find All");
        return bankAccountRepository.findAll();
    }

    @Override
    public Mono<BankAccount> listByHolder(String id){
        log.info("Calling repository for Find by Holder "+id);
        return bankAccountRepository.findBankAccountByHolder(id);
    }

    @Override
    public Mono<BankAccount> listById(String id) {
        log.info("Calling repository for Find by Id");
        return bankAccountRepository.findById(id);
    }

    @Override
    public Mono<Void> removeBankAccount(String id) {
        log.info("Calling repository for Deleting "+ id);
        return bankAccountRepository.deleteById(id);
    }

    @Override
    public Mono<BankAccount> saveBankAccount(BankAccount bankAccount) {
        log.info("Calling repository for inserting Bank Account "+bankAccount.getId());
        return bankAccountRepository.insert(bankAccount);
    }

    @Override
    public Mono<BankAccount> updateBankAccount(BankAccount bankAccount) {
        log.info("Calling Repository for method Update "+ bankAccount.getId());
        return bankAccountRepository.save(bankAccount);
    }
}
