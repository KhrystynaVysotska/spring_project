package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.model.domain.Account;
import ua.lviv.iot.model.service.AbstractService;
import ua.lviv.iot.model.service.implementation.AccountService;

@RequestMapping("/accounts")
@RestController
public class AccountController extends AbstractController<Account> {

	@Autowired
	private AccountService accountService;

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

	@Override
	protected AbstractService<Account> getService() {
		return accountService;
	}
}
