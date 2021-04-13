package ua.lviv.iot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.model.domain.PinCode;
import ua.lviv.iot.model.service.implementation.PinCodeService;

@RequestMapping("/pincodes")
@RestController
public class PinCodeController extends AbstractController<PinCode> {
	private PinCodeService pinCodeService;

	public PinCodeController(PinCodeService pinCodeService) {
		super(pinCodeService);
		this.pinCodeService = pinCodeService;
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<PinCode> update(@PathVariable("id") Integer pinCodeId, @RequestBody PinCode pinCode) {
		pinCode.setId(pinCodeId);
		PinCode updatedPinCode = pinCodeService.update(pinCodeId, pinCode, new PinCode());
		if (updatedPinCode != null) {
			return new ResponseEntity<PinCode>(updatedPinCode, HttpStatus.OK);
		} else {
			return new ResponseEntity<PinCode>(HttpStatus.NOT_FOUND);
		}
	}
}
