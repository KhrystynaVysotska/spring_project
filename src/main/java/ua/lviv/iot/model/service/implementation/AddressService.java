package ua.lviv.iot.model.service.implementation;

import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.repository.AddressRepository;
import ua.lviv.iot.model.service.AbstractService;

@Service
public class AddressService extends AbstractService<Address> {

	@Autowired
	private AddressRepository addressRepository;

	@Override
	protected JpaRepository<Address, Integer> getJpaRepository() {
		return addressRepository;
	}

}
