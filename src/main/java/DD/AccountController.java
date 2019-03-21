package DD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DD.entity.Account;
import DD.entity.Campaign;
import DD.entity.CampaignsToAccounts;
import DD.entity.Monster;
import DD.service.AccountService;
import DD.service.CampaignService;
import DD.service.CampaignsToAccountsService;
import DD.service.CharacterService;
import DD.service.MonsterService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	@Autowired
	AccountService as;
	@Autowired
	CampaignsToAccountsService ctas;
	@Autowired
	CampaignService cas;
	@Autowired
	CharacterService cs;
	@Autowired
	MonsterService ms;
	
	@GetMapping
	public List<Account> getAllAccounts() {
		return as.getAccounts();
	}
	
	
	@PostMapping(path="/post", consumes="application/json")
    public String addAccount(@RequestBody Account o) {
    	System.out.println(o.toString());
    	return as.addAccount(o);
    	
	}
	@PostMapping(path="/login", consumes="application/json")
	public Profile login(@RequestBody Account o)
	{
		System.out.println("Trying to login" + o.toString());
		Account a = as.getAccount(o.getUsername(), o.getPassword());
		if (a == null)
		{
			return null;
		}
		boolean nullCampaignsToAccounts = false, nullCharacters = false, nullMonsters = false;
		CampaignsToAccounts[] c;
		Campaign[] userCampaigns = null;
		DD.entity.Character[] characters = null;
		Monster[] m = null;
		try {
		 c = ctas.getCampaignsForAccount((int) a.getId());
		 userCampaigns = cas.getCampaignsByIds(ctas.getCampaignIdsForAccount((int)a.getId()));
		} catch (NullPointerException e) {
			nullCampaignsToAccounts = true;
		}
		try {
		characters = cs.getCharactersByAccountId((int)a.getId());
		} catch (NullPointerException e) {
			nullCharacters = true;
		}
		try {
		 m = ms.getMonstersByAccountId((int)a.getId());
		} catch (NullPointerException e)
		{
			nullMonsters = true;
		}
		Profile p = new Profile(a, false ? null :userCampaigns, characters, m);
		
		
		System.out.println(p.toString());
		return p;
	}
	
		
	public class Profile
	{
		Account account;
		Campaign[] campaigns;
		DD.entity.Character[] characters;
		Monster[] monsters;
		public Profile(Account account, Campaign[] userCampaigns, DD.entity.Character[] characters, Monster[] monsters) {
			super();
			this.account = account;
			this.campaigns = userCampaigns;
			this.characters = characters;
			this.monsters = monsters;
		}
		@Override
		public String toString() {
			return "Profile [account=" + account + ", campaigns=" + Arrays.toString(campaigns) + ", characters="
					+ Arrays.toString(characters) + "]";
		}
		public Account getAccount() {
			return account;
		}
		public void setAccount(Account account) {
			this.account = account;
		}
		public Campaign[] getCampaigns() {
			return campaigns;
		}
		public void setCampaigns(Campaign[] campaigns) {
			this.campaigns = campaigns;
		}
		public DD.entity.Character[] getCharacters() {
			return characters;
		}
		public void setCharacters(DD.entity.Character[] characters) {
			this.characters = characters;
		}
		public Monster[] getMonsters() {
			return monsters;
		}
		public void setMonsters(Monster[] monsters) {
			this.monsters = monsters;
		}
		
		
	}
}
