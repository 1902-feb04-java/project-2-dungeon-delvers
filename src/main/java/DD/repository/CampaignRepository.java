package DD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DD.entity.Campaign;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Integer>{
	
}
