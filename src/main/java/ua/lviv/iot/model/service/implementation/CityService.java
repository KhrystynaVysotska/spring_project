package ua.lviv.iot.model.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.domain.City;
import ua.lviv.iot.model.repository.CityRepository;
import ua.lviv.iot.model.service.AbstractService;

@Service
public class CityService extends AbstractService<City> {

	@Autowired
	public CityService(CityRepository repository) {
		super(repository);
	}
}
