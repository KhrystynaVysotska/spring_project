package ua.lviv.iot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.model.domain.AccountType;
import ua.lviv.iot.model.service.implementation.AccountTypeService;

@RequestMapping("/account_types")
@RestController
public class AccountTypeController extends AbstractController<AccountType> {
	private AccountTypeService accountTypeService;

	public AccountTypeController(AccountTypeService accountTypeService) {
		super(accountTypeService);
		this.accountTypeService = accountTypeService;
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<AccountType> update(@PathVariable("id") Integer id, @RequestBody AccountType body) {
		body.setId(id);
		AccountType updatedAccountType = accountTypeService.update(id, body, new AccountType());
		if (updatedAccountType != null) {
			return new ResponseEntity<AccountType>(updatedAccountType, HttpStatus.OK);
		} else {
			return new ResponseEntity<AccountType>(HttpStatus.NOT_FOUND);
		}
	}
}
