package ua.lviv.iot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.model.domain.Account;
import ua.lviv.iot.model.service.implementation.AccountService;

@RequestMapping("/accounts")
@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping
	public List<Account> getAccounts() {
		return accountService.findAll();
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Account> getAccount(final @PathVariable("id") Integer accountId) {
		Account foundedAccount = accountService.getById(accountId);
		if (foundedAccount != null) {
			return new ResponseEntity<Account>(foundedAccount, HttpStatus.OK);
		} else {
			return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public Account createAccount(@RequestBody Account newAccount) {
		return accountService.saveToDatabase(newAccount);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Account> deleteAccount(@PathVariable("id") Integer accountId) {
		if (accountService.deleteById(accountId)) {
			return ResponseEntity.status(HttpStatus.OK).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable("id") Integer accountId, @RequestBody Account account) {
		account.setId(accountId);
		Account updatedAccount = accountService.update(accountId, account, new Account());
		if (updatedAccount != null) {
			return new ResponseEntity<Account>(updatedAccount, HttpStatus.OK);
		} else {
			return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
		}
	}
}
