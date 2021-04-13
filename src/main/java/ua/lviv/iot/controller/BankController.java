package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.model.domain.Bank;
import ua.lviv.iot.model.service.implementation.BankService;

@RequestMapping("/banks")
@RestController
public class BankController extends AbstractController<Bank> {
	@Autowired
	private BankService bankService;

	public BankController(BankService bankService) {
		super(bankService);
		this.bankService = bankService;
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Bank> update(@PathVariable("id") Integer bankId, @RequestBody Bank bank) {
		bank.setIdentificationCode(bankId);
		Bank updatedBank = bankService.update(bankId, bank, new Bank());
		if (updatedBank != null) {
			return new ResponseEntity<Bank>(updatedBank, HttpStatus.OK);
		} else {
			return new ResponseEntity<Bank>(HttpStatus.NOT_FOUND);
		}
	}
}
