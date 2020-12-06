package ua.lviv.iot.model.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.domain.BankCard;
import ua.lviv.iot.model.repository.BankCardRepository;
import ua.lviv.iot.model.service.AbstractService;

@Service
public class BankCardService extends AbstractService<BankCard> {

	@Autowired
	private BankCardRepository bankCardRepository;

	@Override
	protected JpaRepository<BankCard, Integer> getJpaRepository() {
		return bankCardRepository;
	}
}
