package DD;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import DD.repository.AccountRepository;
import DD.service.AccountService;

@Configuration
public class BeanConfig {
	@Bean(name="accountrepository")
	public AccountRepository getAccountRepository() {
		AccountRepository bean = new AccountRepository();
//		bean.setDefaultAccountName("Tiffany");
		return bean;
	}
	
	@Bean(name="accountservice")
	public AccountService getAccountService(@Qualifier("accountrepository") AccountRepository ar) {
		AccountService bean = new AccountService();
		bean.setAccountRepository(ar);
		return bean;
	}
}