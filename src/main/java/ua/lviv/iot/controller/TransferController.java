package ua.lviv.iot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.model.domain.Transfer;
import ua.lviv.iot.model.service.implementation.TransferService;

@RequestMapping("/transfers")
@RestController
public class TransferController extends AbstractController<Transfer> {
	private TransferService transferService;

	public TransferController(TransferService transferService) {
		super(transferService);
		this.transferService = transferService;
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Transfer> update(@PathVariable("id") Integer transferId, @RequestBody Transfer transfer) {
		transfer.setId(transferId);
		Transfer updatedTransfer = transferService.update(transferId, transfer, new Transfer());
		if (updatedTransfer != null) {
			return new ResponseEntity<Transfer>(updatedTransfer, HttpStatus.OK);
		} else {
			return new ResponseEntity<Transfer>(HttpStatus.NOT_FOUND);
		}
	}
}
