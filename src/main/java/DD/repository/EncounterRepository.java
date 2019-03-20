package DD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DD.entity.Encounter;

@Repository
public interface EncounterRepository extends JpaRepository<Encounter, Long>{

}