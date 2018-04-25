package prac.security.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import prac.security.model.Role;
import prac.security.model.User;
import prac.security.repository.UserRepository;
import prac.security.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder ;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email) ;
		if( user == null){
			throw new UsernameNotFoundException("Invalid username or password.") ;
		}

		return new org.springframework.security.core.userdetails.User(
				user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}

	public User findByEmail(String email){
		return userRepository.findByEmail(email) ;
	}

	public User save(UserRegistrationDto registration){
		User user = new User();
		user.setFirstname(registration.getFirstName());
		user.setLastname(registration.getLastName());
		user.setEmail(registration.getEmail());
		user.setPassword(passwordEncoder.encode(registration.getPassword()));
		// user.setRoles((Collection<Role>) new Role("ROLE_USER"));

		userRepository.save(user);

		return user;
	}

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole()))
                .collect(Collectors.toList());
    }
}
