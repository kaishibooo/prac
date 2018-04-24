package prac.domain.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import prac.domain.model.account.Account;
import prac.domain.repository.account.AccountRepository;

@Service
public class AccountSharedServiceImpl implements AccountSharedService {

	@Autowired
	AccountRepository accountRepository ;

	@Override
	public Account findOne(String username) {

		Account account = accountRepository.findOne(username) ;

		if (account == null){
			throw new ResourceAccessException("The given account is not found! username="+username) ;
		}

		return account;
	}

}
