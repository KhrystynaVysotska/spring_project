package ua.lviv.iot.model.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.domain.Currency;
import ua.lviv.iot.model.repository.CurrencyRepository;
import ua.lviv.iot.model.service.AbstractService;

@Service
public class CurrencyService extends AbstractService<Currency> {

	@Autowired
	private CurrencyRepository currencyRepository;

	@Override
	protected JpaRepository<Currency, Integer> getJpaRepository() {
		return currencyRepository;
	}
}
