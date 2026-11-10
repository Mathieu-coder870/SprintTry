package fr.simplon.domedespuys.repository;
import fr.simplon.domedespuys.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
