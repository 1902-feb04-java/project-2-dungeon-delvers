package DD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import DD.entity.CampaignsToAccounts;



@Repository
public interface CampaignsToAccountsRepository extends JpaRepository<CampaignsToAccounts, Long> {
	CampaignsToAccounts[] findByAccountId(int id);
	int[] getByCampaignId(int id);
}
