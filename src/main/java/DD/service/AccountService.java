package DD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DD.entity.Account;
import DD.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;

	public AccountService() {
	}

	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public List<Account> getAccounts() {
		return this.accountRepository.findAll();
	}
	
	public String addAccount(Account o) {
		return this.accountRepository.saveAndFlush(o).toString();
	}
	public Account getAccount(int id)
	{
		return this.accountRepository.getOne((long) id);
	}
	public Account getAccount(String username, String password)
	{
		return accountRepository.findByUsernameAndPassword(username, password);
	}
}