package ua.lviv.iot.model.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ua.lviv.iot.model.domain.CardType;
import ua.lviv.iot.model.repository.CardTypeRepository;
import ua.lviv.iot.model.service.AbstractService;

@Service
public class CardTypeService extends AbstractService<CardType> {

	@Autowired
	private CardTypeRepository cardTypeRepository;

	@Override
	protected JpaRepository<CardType, Integer> getJpaRepository() {
		return cardTypeRepository;
	}
}
