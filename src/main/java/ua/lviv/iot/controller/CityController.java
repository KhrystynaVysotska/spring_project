package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.model.domain.City;
import ua.lviv.iot.model.service.AbstractService;
import ua.lviv.iot.model.service.implementation.CityService;

@RequestMapping("/cities")
@RestController
public class CityController extends AbstractController<City> {
	@Autowired
	private CityService cityService;

	@PutMapping(path = "/{id}")
	public ResponseEntity<City> update(@PathVariable("id") Integer cityId, @RequestBody City city) {
		city.setId(cityId);
		City updatedCity = cityService.update(cityId, city, new City());
		if (updatedCity != null) {
			return new ResponseEntity<City>(updatedCity, HttpStatus.OK);
		} else {
			return new ResponseEntity<City>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	protected AbstractService<City> getService() {
		return cityService;
	}
}
