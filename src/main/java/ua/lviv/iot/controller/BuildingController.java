package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.model.domain.Building;
import ua.lviv.iot.model.service.AbstractService;
import ua.lviv.iot.model.service.implementation.BuildingService;

@RequestMapping("/buildings")
@RestController
public class BuildingController extends AbstractController<Building> {
	@Autowired
	private BuildingService buildingService;

	@PutMapping(path = "/{id}")
	public ResponseEntity<Building> update(@PathVariable("id") Integer buildingId, @RequestBody Building building) {
		building.setId(buildingId);
		Building updatedBuilding = buildingService.update(buildingId, building, new Building());
		if (updatedBuilding != null) {
			return new ResponseEntity<Building>(updatedBuilding, HttpStatus.OK);
		} else {
			return new ResponseEntity<Building>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	protected AbstractService<Building> getService() {
		return buildingService;
	}
}
