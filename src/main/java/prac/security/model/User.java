package prac.security.model;

import java.util.Collection;

import lombok.Data;

@Data
public class User {

	private Long user_id ;

	private String firstname ;

	private String lastname ;

	private String password ;

	private String email ;

	private boolean enabled ;

	private Collection<Role> roles;

    public User() {
    }

    public User(String firstname, String lastname, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public User(String firstname, String lastname, String email, String password, Collection<Role> roles) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }


}
