package com.example.Loan.dto;

import java.math.BigDecimal;

public record LoanRequest(String accountNumber, String loanType, BigDecimal amount, String status) {
}