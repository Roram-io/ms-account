package com.nttdata.bankaccounts.repository;

import com.nttdata.bankaccounts.model.BankAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface BankAccountRepository extends ReactiveMongoRepository<BankAccount, String> {

    Mono<BankAccount> findBankAccountByHolder(String id);
}
