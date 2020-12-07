package ua.lviv.iot.model.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.domain.Building;
import ua.lviv.iot.model.repository.BuildingRepository;
import ua.lviv.iot.model.service.AbstractService;

@Service
public class BuildingService extends AbstractService<Building> {

	@Autowired
	public BuildingService(BuildingRepository repository) {
		super(repository);
	}
}
