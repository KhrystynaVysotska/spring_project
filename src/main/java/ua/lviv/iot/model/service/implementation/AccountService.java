package ua.lviv.iot.model.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.domain.Account;
import ua.lviv.iot.model.repository.AccountRepository;
import ua.lviv.iot.model.service.AbstractService;

@Service
public class AccountService extends AbstractService<Account> {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	protected JpaRepository<Account, Integer> getJpaRepository() {
		return accountRepository;
	}
}
