package monolith.user.logic.api.to;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import monolith.cart.dataaccess.api.CartEntity;
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
	
	private CartEntity cartEntity;

	public UserTO() {
	}

	public UserTO(String username, String password, Role role, String email) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
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

	public CartEntity getCartEntity() {
		return cartEntity;
	}

	public void setCartEntity(CartEntity cartEntity) {
		this.cartEntity = cartEntity;
	}

	public void setId(Long id) {
		this.id = id;
	}	
	

}
