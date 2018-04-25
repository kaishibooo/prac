package prac.security.repository;

import prac.security.model.User;

public interface UserRepository  {
	User findByEmail(String email) ;

	int save(User user) ;
}