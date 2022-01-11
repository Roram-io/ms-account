package com.nttdata.bankaccounts.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "BankAccount")
public class BankAccount {
    private String type;

    @Id
    private String id= UUID.randomUUID().toString();
    private String holder;
    private double amount;
    private int transactionLimit;

    
}
