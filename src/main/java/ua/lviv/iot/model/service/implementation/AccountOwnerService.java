package ua.lviv.iot.model.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.domain.AccountOwner;
import ua.lviv.iot.model.repository.AccountOwnerRepository;
import ua.lviv.iot.model.service.AbstractService;

@Service
public class AccountOwnerService extends AbstractService<AccountOwner> {

	@Autowired
	public AccountOwnerService(AccountOwnerRepository repository) {
		super(repository);
	}
}
