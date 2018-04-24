package prac.domain.service.account;

import prac.domain.model.account.Account;

public interface AccountSharedService {
	Account findOne(String username);
}
