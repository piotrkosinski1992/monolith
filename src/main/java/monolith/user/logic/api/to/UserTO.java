package monolith.user.logic.api.to;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import monolith.user.common.api.datatype.Role;
import monolith.user.dataaccess.api.UserEntity;

public class UserTO {

	private Long id;
	
	@NotEmpty(message = "Username can't be empty")
	private String username;
	
	@Size(min = 8, max = 20, message = "Password must have at least 8 signs and can't be bigger that 20 signs")
	@NotEmpty
	private String password;
		
	@Email(message = "Email should be valid")
	private String email;
	
	private Role role;

	public UserTO() {
	}

	public UserTO(String username, Role role, String password, String email) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	public UserTO(UserEntity userEntity) {
		this.id = userEntity.getId();
		this.email = userEntity.getEmail();
		this.username = userEntity.getUsername();
		this.role = userEntity.getRole();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}	
}
