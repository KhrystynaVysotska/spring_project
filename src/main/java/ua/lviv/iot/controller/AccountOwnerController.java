package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.model.domain.AccountOwner;
import ua.lviv.iot.model.service.AbstractService;
import ua.lviv.iot.model.service.implementation.AccountOwnerService;

@RequestMapping("/owners")
@RestController
public class AccountOwnerController extends AbstractController<AccountOwner> {
	@Autowired
	private AccountOwnerService accountOwnerService;

	@PutMapping(path = "/{id}")
	public ResponseEntity<AccountOwner> updateAccountOwner(@PathVariable("id") Integer accountOwnerId,
			@RequestBody AccountOwner accountOwner) {
		accountOwner.setId(accountOwnerId);
		AccountOwner updatedAccountOwner = accountOwnerService.update(accountOwnerId, accountOwner, new AccountOwner());
		if (updatedAccountOwner != null) {
			return new ResponseEntity<AccountOwner>(updatedAccountOwner, HttpStatus.OK);
		} else {
			return new ResponseEntity<AccountOwner>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	protected AbstractService<AccountOwner> getService() {
		return accountOwnerService;
	}
}
