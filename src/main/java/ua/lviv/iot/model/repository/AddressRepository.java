package ua.lviv.iot.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
