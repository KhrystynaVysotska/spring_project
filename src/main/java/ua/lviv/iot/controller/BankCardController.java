package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.model.domain.BankCard;
import ua.lviv.iot.model.service.AbstractService;
import ua.lviv.iot.model.service.implementation.BankCardService;

@RequestMapping("/bank_cards")
@RestController
public class BankCardController extends AbstractController<BankCard> {
	@Autowired
	private BankCardService bankCardService;

	@PutMapping(path = "/{id}")
	public ResponseEntity<BankCard> update(@PathVariable("id") Integer bankCardId, @RequestBody BankCard bankCard) {
		bankCard.setId(bankCardId);
		BankCard updatedBankCard = bankCardService.update(bankCardId, bankCard, new BankCard());
		if (updatedBankCard != null) {
			return new ResponseEntity<BankCard>(updatedBankCard, HttpStatus.OK);
		} else {
			return new ResponseEntity<BankCard>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	protected AbstractService<BankCard> getService() {
		return bankCardService;
	}
}
