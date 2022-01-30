package com.nttdata.bankaccounts.service.impl;

import com.nttdata.bankaccounts.config.WebClientConfig;
import com.nttdata.bankaccounts.model.BankAccount;
import com.nttdata.bankaccounts.model.Card;
import com.nttdata.bankaccounts.repository.BankAccountRepository;
import com.nttdata.bankaccounts.service.BankAccountService;
import com.nttdata.bankaccounts.utils.AccountConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    Logger log = LoggerFactory.getLogger(BankAccountServiceImpl.class);

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Autowired
    private WebClient webClientCard;

    @Override
    public Flux<BankAccount> listBankAccounts() {
        log.info("Calling repository for Find All");
        return bankAccountRepository.findAll();
    }

    @Override
    public Flux<BankAccount> listByHolder(String id){
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
        log.info("Bank Account of type "+bankAccount.getType());

        if (bankAccount.getType().equals("Pyme")) {
            return webClientCard.get().uri("http://localhost:8885/api/v1/card/owner/" + bankAccount.getHolder())
                    .retrieve().bodyToFlux(Card.class).next().switchIfEmpty(Mono.empty())
                    .flatMap(e-> {
                        bankAccount.setFee(AccountConst.feePyme);
                        bankAccount.setFreeLimit(AccountConst.freeLimitPyme);
                        bankAccount.setTransactionLimit(AccountConst.limitPyme);

                    return bankAccountRepository.save(bankAccount);});
        } else if (bankAccount.getType().equals("Vip")) {
            return webClientCard.get().uri("http://localhost:8885/api/v1/card/owner/" + bankAccount.getHolder())
                    .retrieve().bodyToFlux(Card.class).next().switchIfEmpty(Mono.empty())
                    .flatMap(e-> {
                        bankAccount.setFee(AccountConst.feeVip);
                        bankAccount.setFreeLimit(AccountConst.freeLimitVip);
                        bankAccount.setTransactionLimit(AccountConst.limitVip);

                        return bankAccountRepository.save(bankAccount);});
        };






        switch (bankAccount.getType()){
            case "Regular":
            bankAccount.setFee(AccountConst.feeRegular);
            bankAccount.setTransactionLimit(AccountConst.limitRegular);
            bankAccount.setFreeLimit(AccountConst.freeLimitRegular);
            log.info("Depositado el tipo Regular");
            return bankAccountRepository.save(bankAccount);
            case "FixedTerm":
                bankAccount.setFee(AccountConst.feeFixedTerm);
                bankAccount.setTransactionLimit(AccountConst.limitFixedTerm);
                bankAccount.setFreeLimit(AccountConst.freeLimitFixedTerm);
                log.info("Depositado el tipo FixedTerm");
                return bankAccountRepository.save(bankAccount);
            case "Savings":
                bankAccount.setFee(AccountConst.feeSavings);
                bankAccount.setTransactionLimit(AccountConst.limitSavings);
                bankAccount.setFreeLimit(AccountConst.freeLimitSavings);
                log.info("Depositado el tipo Savings");
                return bankAccountRepository.save(bankAccount);
            case "Pyme":
                if (true) return Mono.empty(); //If there is no credit card.
                bankAccount.setFee(AccountConst.feePyme);
                bankAccount.setTransactionLimit(AccountConst.limitPyme);
                bankAccount.setFreeLimit(AccountConst.freeLimitPyme);
                log.info("Depositado el tipo Pyme");
                return bankAccountRepository.save(bankAccount);
            case "Vip":
                if (true) return Mono.empty(); //If there is no credit card.
                bankAccount.setFee(AccountConst.feeVip);
                bankAccount.setTransactionLimit(AccountConst.limitVip);
                bankAccount.setFreeLimit(AccountConst.freeLimitVip);
                log.info("Depositado el tipo Vip");
                return bankAccountRepository.save(bankAccount);

        }
        return Mono.empty();
    }

    @Override
    public Mono<BankAccount> updateBankAccount(BankAccount bankAccount) {
        log.info("Calling Repository for method Update "+ bankAccount.getId());
        return bankAccountRepository.save(bankAccount);
    }
}
