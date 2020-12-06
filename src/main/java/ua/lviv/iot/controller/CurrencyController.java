package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.model.domain.Currency;
import ua.lviv.iot.model.service.AbstractService;
import ua.lviv.iot.model.service.implementation.CurrencyService;

@RequestMapping("/currency")
@RestController
public class CurrencyController extends AbstractController<Currency> {
	@Autowired
	private CurrencyService currencyService;

	@PutMapping(path = "/{id}")
	public ResponseEntity<Currency> update(@PathVariable("id") Integer currencyId, @RequestBody Currency currency) {
		currency.setId(currencyId);
		Currency updatedCurrency = currencyService.update(currencyId, currency, new Currency());
		if (updatedCurrency != null) {
			return new ResponseEntity<Currency>(updatedCurrency, HttpStatus.OK);
		} else {
			return new ResponseEntity<Currency>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	protected AbstractService<Currency> getService() {
		return currencyService;
	}
}
