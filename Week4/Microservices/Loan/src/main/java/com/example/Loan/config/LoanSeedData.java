package com.example.Loan.config;

import com.example.Loan.entity.Loan;
import com.example.Loan.repository.LoanRepository;
import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoanSeedData {

	@Bean
	CommandLineRunner seedLoans(LoanRepository loanRepository) {
		return args -> {
			if (loanRepository.count() > 0) {
				return;
			}

			Loan firstLoan = new Loan();
			firstLoan.setAccountNumber("ACC1001");
			firstLoan.setLoanType("Personal Loan");
			firstLoan.setAmount(new BigDecimal("150000.00"));
			firstLoan.setStatus("APPROVED");

			Loan secondLoan = new Loan();
			secondLoan.setAccountNumber("ACC1002");
			secondLoan.setLoanType("Home Loan");
			secondLoan.setAmount(new BigDecimal("800000.00"));
			secondLoan.setStatus("PENDING");

			loanRepository.save(firstLoan);
			loanRepository.save(secondLoan);
		};
	}
}