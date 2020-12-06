package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.model.domain.Street;
import ua.lviv.iot.model.service.AbstractService;
import ua.lviv.iot.model.service.implementation.StreetService;

@RequestMapping("/streets")
@RestController
public class StreetController extends AbstractController<Street> {
	@Autowired
	private StreetService streetService;

	@PutMapping(path = "/{id}")
	public ResponseEntity<Street> update(@PathVariable("id") Integer streetId, @RequestBody Street street) {
		street.setId(streetId);
		Street updatedStreet = streetService.update(streetId, street, new Street());
		if (updatedStreet != null) {
			return new ResponseEntity<Street>(updatedStreet, HttpStatus.OK);
		} else {
			return new ResponseEntity<Street>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	protected AbstractService<Street> getService() {
		return streetService;
	}
}
