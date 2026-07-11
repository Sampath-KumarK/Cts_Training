package com.example.Loan.controller;

import com.example.Loan.dto.LoanRequest;
import com.example.Loan.dto.LoanResponse;
import com.example.Loan.entity.Loan;
import com.example.Loan.repository.LoanRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

	private final LoanRepository loanRepository;

	public LoanController(LoanRepository loanRepository) {
		this.loanRepository = loanRepository;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public LoanResponse createLoan(@RequestBody LoanRequest request) {
		Loan loan = new Loan();
		loan.setAccountNumber(request.accountNumber());
		loan.setLoanType(request.loanType());
		loan.setAmount(request.amount());
		loan.setStatus(request.status());
		return toResponse(loanRepository.save(loan));
	}

	@GetMapping
	public List<LoanResponse> getAllLoans() {
		return loanRepository.findAll().stream().map(this::toResponse).toList();
	}

	@GetMapping("/{accountNumber}")
	public LoanResponse getLoanByAccountNumber(@PathVariable String accountNumber) {
		return loanRepository.findByAccountNumber(accountNumber)
			.map(this::toResponse)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Loan not found"));
	}

	private LoanResponse toResponse(Loan loan) {
		return new LoanResponse(loan.getId(), loan.getAccountNumber(), loan.getLoanType(), loan.getAmount(), loan.getStatus());
	}
}