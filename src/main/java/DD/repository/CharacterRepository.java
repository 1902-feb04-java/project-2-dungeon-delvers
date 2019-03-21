package DD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DD.entity.Character;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long>{
	Character[] findAllByPlayerAccount(int id);
}
