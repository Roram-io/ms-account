package com.nttdata.bankaccounts.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class Card {
    private String type;
    private String id;
    private String ownerId;

    private String mainAccount;
    private ArrayList<String> extraAccounts;
}
