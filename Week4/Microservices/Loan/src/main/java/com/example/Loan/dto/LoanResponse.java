package com.example.Loan.dto;

import java.math.BigDecimal;

public record LoanResponse(Long id, String accountNumber, String loanType, BigDecimal amount, String status) {
}