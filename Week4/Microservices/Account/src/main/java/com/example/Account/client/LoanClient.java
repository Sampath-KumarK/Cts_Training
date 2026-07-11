package com.example.Account.client;

import com.example.Account.dto.LoanInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "loan-service")
public interface LoanClient {

	@GetMapping("/api/loans/{accountNumber}")
	LoanInfoResponse getLoanByAccountNumber(@PathVariable("accountNumber") String accountNumber);
}