package ua.lviv.iot.model.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.domain.Address;
import ua.lviv.iot.model.repository.AddressRepository;
import ua.lviv.iot.model.service.AbstractService;

@Service
public class AddressService extends AbstractService<Address> {

	@Autowired
	public AddressService(AddressRepository repository) {
		super(repository);
	}
}
