package ua.lviv.iot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.model.domain.CardType;
import ua.lviv.iot.model.service.implementation.CardTypeService;

@RequestMapping("/card_types")
@RestController
public class CardTypeController extends AbstractController<CardType> {
	private CardTypeService cardTypeService;

	public CardTypeController(CardTypeService cardTypeService) {
		super(cardTypeService);
		this.cardTypeService = cardTypeService;
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<CardType> update(@PathVariable("id") Integer cardTypeId, @RequestBody CardType cardType) {
		cardType.setId(cardTypeId);
		CardType updatedCardType = cardTypeService.update(cardTypeId, cardType, new CardType());
		if (updatedCardType != null) {
			return new ResponseEntity<CardType>(updatedCardType, HttpStatus.OK);
		} else {
			return new ResponseEntity<CardType>(HttpStatus.NOT_FOUND);
		}
	}
}
