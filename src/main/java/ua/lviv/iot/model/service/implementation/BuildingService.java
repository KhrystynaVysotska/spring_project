package ua.lviv.iot.model.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ua.lviv.iot.model.domain.Building;
import ua.lviv.iot.model.repository.BuildingRepository;
import ua.lviv.iot.model.service.AbstractService;

@Service
public class BuildingService extends AbstractService<Building> {

	@Autowired
	private BuildingRepository buildingRepository;

	@Override
	protected JpaRepository<Building, Integer> getJpaRepository() {
		return buildingRepository;
	}

}
