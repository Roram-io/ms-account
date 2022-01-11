package com.nttdata.bankaccounts.controller;

import com.nttdata.bankaccounts.model.BankAccount;
import com.nttdata.bankaccounts.service.BankAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/bankaccount")
public class BankAccountController {

    Logger log = LoggerFactory.getLogger(BankAccountController.class);

    @Autowired
    BankAccountService bankAccountService;

    @GetMapping
    public Flux<BankAccount> getCustomers(){
        log.info("Listing all BankAccounts: ");
        return bankAccountService.listBankAccounts();
    }

    @GetMapping("/{id}")
    public Mono<BankAccount> getBankAccountById(@PathVariable("id") String id){
        log.info("Searching BankAccount with Id "+id);
        return bankAccountService.listById(id);
    }

    @GetMapping("/holder/{id}")
    public Mono<BankAccount> getBankAccountByHolder(@PathVariable("id") String id){
        log.info("Searching BankAccount with holder with Id "+id);
        return bankAccountService.listByHolder(id);
    }

    @PostMapping("/save")
    public Mono<BankAccount> saveBankAccount(@RequestBody BankAccount bankAccount){
        log.info("Inserting a new BankAccount");
        return bankAccountService.saveBankAccount(bankAccount);
    }

    @PutMapping("/update")
    public Mono<BankAccount> updateBankAccount(@RequestBody BankAccount customer){
        log.info("Updating the following Id: "+customer.getId());
        return bankAccountService.updateBankAccount(customer);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> removeBankAccount(@PathVariable("id") String id){
        log.info("Removing the following BankAccount: "+ id);
        return bankAccountService.removeBankAccount(id);
    }


}
