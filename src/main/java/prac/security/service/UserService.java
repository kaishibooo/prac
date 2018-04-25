package prac.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import prac.security.model.User;
import prac.security.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

	User findByEmail(String email) ;

	User save(UserRegistrationDto registration) ;
}
