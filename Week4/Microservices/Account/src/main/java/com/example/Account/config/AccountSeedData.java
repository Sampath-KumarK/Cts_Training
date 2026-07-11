package com.example.Account.config;

import com.example.Account.entity.Account;
import com.example.Account.repository.AccountRepository;
import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountSeedData {

	@Bean
	CommandLineRunner seedAccounts(AccountRepository accountRepository) {
		return args -> {
			if (accountRepository.count() > 0) {
				return;
			}

			Account firstAccount = new Account();
			firstAccount.setAccountNumber("ACC1001");
			firstAccount.setAccountHolder("Sampath");
			firstAccount.setBalance(new BigDecimal("25000.00"));

			Account secondAccount = new Account();
			secondAccount.setAccountNumber("ACC1002");
			secondAccount.setAccountHolder("Anjali");
			secondAccount.setBalance(new BigDecimal("42000.00"));

			accountRepository.save(firstAccount);
			accountRepository.save(secondAccount);
		};
	}
}