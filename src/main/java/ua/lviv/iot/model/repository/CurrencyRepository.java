package ua.lviv.iot.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.domain.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {

}
