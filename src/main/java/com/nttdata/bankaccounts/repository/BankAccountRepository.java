package com.nttdata.bankaccounts.repository;

import com.nttdata.bankaccounts.model.BankAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BankAccountRepository extends ReactiveMongoRepository<BankAccount, String> {
}
