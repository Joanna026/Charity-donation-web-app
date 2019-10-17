package pl.coderslab.charity.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.charity.model.entities.Institution;

import java.util.List;
import java.util.Optional;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {

    @Query(nativeQuery = true, value = "SELECT COUNT(DISTINCT institution_id) FROM donations")
    Optional<Integer> countAllByInstitution();
    @Query(nativeQuery = true, value = "SELECT * FROM institutions WHERE IF(archived, 'true', 'false') LIKE '%false%'")
    List<Institution> findAllByArchivedFalse();

}
