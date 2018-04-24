package prac.domain.service.userdetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import prac.domain.model.account.Account;
import prac.domain.service.account.AccountSharedService;

@Service
public class AccountUserDetailsServcie implements  UserDetailsService  {

	@Autowired
	AccountSharedService accountSharedServie ;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try{
			Account account = accountSharedServie.findOne(username);
			return new AccountUserDetails(account) ;
		} catch(ResourceAccessException e){
			throw new UsernameNotFoundException ("user not found" , e);
		}
	}

}
