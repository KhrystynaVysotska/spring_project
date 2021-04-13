package ua.lviv.iot.model.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.domain.AccountType;
import ua.lviv.iot.model.repository.AccountTypeRepository;
import ua.lviv.iot.model.service.AbstractService;

@Service
public class AccountTypeService extends AbstractService<AccountType> {
	@Autowired
	public AccountTypeService(AccountTypeRepository repository) {
		super(repository);
	}
}
