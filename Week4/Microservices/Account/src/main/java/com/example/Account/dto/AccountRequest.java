package com.example.Account.dto;

import java.math.BigDecimal;

public record AccountRequest(String accountNumber, String accountHolder, BigDecimal balance) {
}