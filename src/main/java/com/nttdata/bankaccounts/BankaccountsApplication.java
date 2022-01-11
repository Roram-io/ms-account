package com.nttdata.bankaccounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class BankaccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankaccountsApplication.class, args);
	}

}
