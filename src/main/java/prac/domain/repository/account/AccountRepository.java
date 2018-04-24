package prac.domain.repository.account;

import org.apache.ibatis.annotations.Mapper;

import prac.domain.model.account.Account;

@Mapper
public interface AccountRepository {
	Account findOne(String username) ;
}
