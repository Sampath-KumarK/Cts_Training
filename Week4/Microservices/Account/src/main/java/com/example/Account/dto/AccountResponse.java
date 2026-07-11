package com.example.Account.dto;

import java.math.BigDecimal;

public record AccountResponse(Long id, String accountNumber, String accountHolder, BigDecimal balance) {
}