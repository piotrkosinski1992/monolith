package monolith.user.logic.api.to;

import monolith.user.common.api.datatype.Role;
import monolith.user.dataaccess.api.UserEntity;

public class UserTO {

	private String username;
	
	private Role role;

	public UserTO() {
	}

	public UserTO(String username, Role role) {
		this.username = username;
		this.role = role;
	}
	
	public UserTO(UserEntity userEntity) {
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
}
