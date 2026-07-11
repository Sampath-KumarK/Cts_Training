package com.example.Loan.repository;

import com.example.Loan.entity.Loan;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {

	Optional<Loan> findByAccountNumber(String accountNumber);
}