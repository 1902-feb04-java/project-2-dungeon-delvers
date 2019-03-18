package DD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DD.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

}

//@Repository
//public class AccountRepository {
//	List<Account> accounts;
////	@Value("Tiffany")
////	String defaultArtistName;
//
//	public AccountRepository() {
//	}
//	
//	public List<Account> getAllAccounts() {
//		accounts = new ArrayList<>();
//		accounts.add(new Account(1, "u1", "p1", "e1"));
//		accounts.add(new Account(2, "u2", "p2", "e2"));
//
//		return accounts;
//	}
//
////	public void setDefaultArtistName(String defaultArtistName) {
////		this.defaultArtistName = defaultArtistName;
////	}
//	
//}