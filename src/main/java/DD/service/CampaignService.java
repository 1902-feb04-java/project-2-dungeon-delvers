package DD.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DD.entity.Campaign;
import DD.repository.CampaignRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DD.entity.Campaign;
import DD.repository.CampaignRepository;

@Service
public class CampaignService {
	
	@Autowired
	private CampaignRepository cmr;

	public CampaignService() {
	
	}

	public void setCampaignRepository(CampaignRepository cmr) {
		this.cmr = cmr;
	}

	public List<Campaign> getCampaigns() {
		return this.cmr.findAll();
	}
	
	public String addCampaign(Campaign c) {
		return this.cmr.saveAndFlush(c).toString();
	}
	public Campaign[] getCampaignsByIds(int[] id)
	{
		ArrayList<Campaign> c = new ArrayList<Campaign>();
		for(int i : id)
		{
			Campaign ca = getCampaignById(i);
			if (ca != null)
			{
				c.add(ca);
			}
		}
		Campaign[] toArr = new Campaign[c.size()];
		toArr = c.toArray(toArr);
		return toArr;
	}
	public Campaign getCampaignById(int id)
	{
		return cmr.getOne(id);
	}
	
}