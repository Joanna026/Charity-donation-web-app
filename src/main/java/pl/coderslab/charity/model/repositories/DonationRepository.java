package pl.coderslab.charity.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.model.entities.Donation;

import java.util.Optional;

public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query("SELECT SUM(d.quantity) AS total FROM Donation d")
    Optional<Integer> getTotalQuantity();

}
