package ua.lviv.iot.model.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ua.lviv.iot.model.domain.PinCode;
import ua.lviv.iot.model.repository.PinCodeRepository;
import ua.lviv.iot.model.service.AbstractService;

@Service
public class PinCodeService extends AbstractService<PinCode> {

	@Autowired
	private PinCodeRepository pinCodeRepository;

	@Override
	protected JpaRepository<PinCode, Integer> getJpaRepository() {
		return pinCodeRepository;
	}
}
