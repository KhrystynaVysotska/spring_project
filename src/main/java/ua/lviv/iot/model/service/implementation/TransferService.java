package ua.lviv.iot.model.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.domain.Transfer;
import ua.lviv.iot.model.repository.TransferRepository;
import ua.lviv.iot.model.service.AbstractService;

@Service
public class TransferService extends AbstractService<Transfer> {

	@Autowired
	public TransferService(TransferRepository repository) {
		super(repository);
	}
}
