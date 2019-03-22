package DD.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import DD.entity.Account;
import DD.entity.CampaignsToAccounts;
import DD.repository.CampaignsToAccountsRepository;

@Service
public class CampaignsToAccountsService {
	@Autowired
	private CampaignsToAccountsRepository rep;
	
	public CampaignsToAccountsService() {
	}

	public void setcampaignsToAccountRepository(CampaignsToAccountsRepository campaignsToAccountRepository) {
		this.rep = campaignsToAccountRepository;
	}

	public List<CampaignsToAccounts> getAccounts() {
		return this.rep.findAll();
	}
	
	public String addCampaignsToAccounts(CampaignsToAccounts o) {
		return this.rep.saveAndFlush(o).toString();
	}
	public CampaignsToAccounts getCampaignsToAccounts(int id)
	{
		return this.rep.getOne((long) id);
	}
	public CampaignsToAccounts[] getCampaignsForAccount(int id)
	{
		return this.rep.findByAccountId(id);
	}
	public int[] getCampaignIdsForAccount(int id)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		CampaignsToAccounts[] c = rep.findByAccountId(id);
		for(CampaignsToAccounts ca: c)
		{
			list.add(ca.getCampaign_id());
		}
		int[] ca = new int[list.size()];
		for (int x = 0; x < ca.length; x++)
		{
			ca[x] = list.get(x);
		}
		return ca;
	}
	public int[] getAccountIdsForCampaign(int id)
	{
		return rep.getByCampaignId(id);
	}
}
