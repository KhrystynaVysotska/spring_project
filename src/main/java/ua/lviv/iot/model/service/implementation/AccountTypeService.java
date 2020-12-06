package ua.lviv.iot.model.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ua.lviv.iot.model.domain.AccountType;
import ua.lviv.iot.model.repository.AccountTypeRepository;
import ua.lviv.iot.model.service.AbstractService;

@Service
public class AccountTypeService extends AbstractService<AccountType> {

	@Autowired
	private AccountTypeRepository accountTypeRepository;

	@Override
	protected JpaRepository<AccountType, Integer> getJpaRepository() {
		return accountTypeRepository;
	}
}
