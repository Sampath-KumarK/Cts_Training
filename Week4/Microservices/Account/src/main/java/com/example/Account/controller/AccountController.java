package com.example.Account.controller;

import com.example.Account.client.LoanClient;
import com.example.Account.dto.AccountLoanView;
import com.example.Account.dto.AccountRequest;
import com.example.Account.dto.AccountResponse;
import com.example.Account.dto.LoanInfoResponse;
import com.example.Account.entity.Account;
import com.example.Account.repository.AccountRepository;
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
@RequestMapping("/api/accounts")
public class AccountController {

	private final AccountRepository accountRepository;
	private final LoanClient loanClient;

	public AccountController(AccountRepository accountRepository, LoanClient loanClient) {
		this.accountRepository = accountRepository;
		this.loanClient = loanClient;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AccountResponse createAccount(@RequestBody AccountRequest request) {
		Account account = new Account();
		account.setAccountNumber(request.accountNumber());
		account.setAccountHolder(request.accountHolder());
		account.setBalance(request.balance());
		return toResponse(accountRepository.save(account));
	}

	@GetMapping
	public List<AccountResponse> getAllAccounts() {
		return accountRepository.findAll().stream().map(this::toResponse).toList();
	}

	@GetMapping("/{accountNumber}")
	public AccountResponse getAccount(@PathVariable String accountNumber) {
		return toResponse(findAccount(accountNumber));
	}

	@GetMapping("/{accountNumber}/with-loan")
	public AccountLoanView getAccountWithLoan(@PathVariable String accountNumber) {
		Account account = findAccount(accountNumber);
		LoanInfoResponse loanInfo = loanClient.getLoanByAccountNumber(accountNumber);
		return new AccountLoanView(toResponse(account), loanInfo);
	}

	private Account findAccount(String accountNumber) {
		return accountRepository.findByAccountNumber(accountNumber)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found"));
	}

	private AccountResponse toResponse(Account account) {
		return new AccountResponse(account.getId(), account.getAccountNumber(), account.getAccountHolder(), account.getBalance());
	}
}