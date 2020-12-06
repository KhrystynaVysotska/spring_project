package ua.lviv.iot.model.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ua.lviv.iot.model.domain.Street;
import ua.lviv.iot.model.repository.StreetRepository;
import ua.lviv.iot.model.service.AbstractService;

@Service
public class StreetService extends AbstractService<Street> {

	@Autowired
	private StreetRepository streetRepository;

	@Override
	protected JpaRepository<Street, Integer> getJpaRepository() {
		return streetRepository;
	}

}
