package monolith.user.dataaccess.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import monolith.user.common.api.datatype.Role;
import monolith.user.logic.api.to.UserTO;

@Entity
public class UserEntity {

	@Id
	@GeneratedValue
	private Long id;
	
	private String username;
	
	private String password;
	
	@Column(unique = true)
	private String email;
	
	@Enumerated(EnumType.STRING)
	private Role role;

	public UserEntity() {
	}

	public UserEntity(String username, String password, Role role, String email) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	public UserEntity(UserEntity userEntity) {
		this.id = userEntity.getId();
		this.role = userEntity.getRole();
		this.username = userEntity.getUsername();
		this.password = userEntity.getPassword();
	}

	public UserEntity(UserTO userTO) {
		this.email = userTO.getEmail();
		this.username = userTO.getUsername();
		this.password = userTO.getPassword();
		this.role = userTO.getRole();
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
