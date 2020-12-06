package ua.lviv.iot.model.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ua.lviv.iot.model.domain.AccountOwner;
import ua.lviv.iot.model.repository.AccountOwnerRepository;
import ua.lviv.iot.model.service.AbstractService;

@Service
public class AccountOwnerService extends AbstractService<AccountOwner> {

	@Autowired
	private AccountOwnerRepository accountOwnerRepository;

	@Override
	protected JpaRepository<AccountOwner, Integer> getJpaRepository() {
		return accountOwnerRepository;
	}
}
