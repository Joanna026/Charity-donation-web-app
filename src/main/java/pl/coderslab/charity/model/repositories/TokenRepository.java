package pl.coderslab.charity.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.model.entities.VerificationToken;

public interface TokenRepository extends JpaRepository<VerificationToken, Long> {
}
