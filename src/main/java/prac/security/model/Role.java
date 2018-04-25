package prac.security.model;

import lombok.Data;

@Data
public class Role {

	private Long user_id ;

	private String role ;

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

}
