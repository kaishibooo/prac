package prac.domain.model.account;

import java.io.Serializable;

import lombok.Data;

@Data
public class Account implements Serializable {

	private static final long serialVersionUID = 1L ;

	private String username ;

	private String password ;

	private String firstName ;

	private String lastName ;


}
