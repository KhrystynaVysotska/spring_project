package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.model.domain.Address;
import ua.lviv.iot.model.service.AbstractService;
import ua.lviv.iot.model.service.implementation.AddressService;

@RequestMapping("/addresses")
@RestController
public class AddressController extends AbstractController<Address> {
	@Autowired
	private AddressService addressService;

	@PutMapping(path = "/{id}")
	public ResponseEntity<Address> update(@PathVariable("id") Integer addressId, @RequestBody Address address) {
		address.setId(addressId);
		Address updatedAddress = addressService.update(addressId, address, new Address());
		if (updatedAddress != null) {
			return new ResponseEntity<Address>(updatedAddress, HttpStatus.OK);
		} else {
			return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	protected AbstractService<Address> getService() {
		return addressService;
	}
}
