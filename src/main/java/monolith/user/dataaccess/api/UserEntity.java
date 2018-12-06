package monolith.user.dataaccess.api;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import monolith.cart.dataaccess.api.CartEntity;
import monolith.user.common.api.datatype.Role;
import monolith.user.logic.api.to.UserTO;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"email"})}) //doesn't work
public class UserEntity {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false) 
	private String username;
	
	@Column(nullable=false) 
	private String password;
	
	@Column(nullable=false)
	private String email;
	
	@Column(nullable=false) 
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CartEntity cartEntity;

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

	public CartEntity getCartEntity() {
		return cartEntity;
	}

	public void setCartEntity(CartEntity cartEntity) {
		this.cartEntity = cartEntity;
	}	
}
