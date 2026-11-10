package fr.simplon.domedespuys.repository;
import fr.simplon.domedespuys.entities.Address;
import fr.simplon.domedespuys.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AddressRepository extends  JpaRepository<Address, Long>{
    List<Address> findAllByUser(User user);
}
