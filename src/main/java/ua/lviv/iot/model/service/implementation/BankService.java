package ua.lviv.iot.model.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.domain.Bank;
import ua.lviv.iot.model.repository.BankRepository;
import ua.lviv.iot.model.service.AbstractService;

@Service
public class BankService extends AbstractService<Bank> {

	@Autowired
	private BankRepository bankRepository;

	@Override
	protected JpaRepository<Bank, Integer> getJpaRepository() {
		return bankRepository;
	}
}
