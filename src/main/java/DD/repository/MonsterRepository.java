package DD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DD.entity.Monster;

@Repository
public interface MonsterRepository extends JpaRepository<Monster, Long> {

}
