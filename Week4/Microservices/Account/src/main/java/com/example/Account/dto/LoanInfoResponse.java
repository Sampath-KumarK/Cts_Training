package com.example.Account.dto;

import java.math.BigDecimal;

public record LoanInfoResponse(Long id, String accountNumber, String loanType, BigDecimal amount, String status) {
}