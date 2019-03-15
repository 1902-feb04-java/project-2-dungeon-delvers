package DD;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DD.entity.Account;
import DD.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	@Autowired
	AccountService as;
	
	@GetMapping
	public List<Account> getAllAccounts() {
		return as.getAccounts();
	}
	
	@PostMapping(path="/post", consumes="application/json")
    public String addAccount(@RequestBody Account o) {
    	System.out.println(o.toString());
    	return as.addAccount(o);
    	
	}
}
