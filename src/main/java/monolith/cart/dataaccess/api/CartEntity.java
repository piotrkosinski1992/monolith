package monolith.cart.dataaccess.api;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import monolith.cart.logic.api.to.CartTO;
import monolith.user.dataaccess.api.UserEntity;

@Entity
public class CartEntity {

	@Id
	@GeneratedValue
	private Long id;

	@OneToMany(mappedBy = "cartEntity", cascade = CascadeType.ALL)
	private List<CartItemEntity> cartItems = new ArrayList<>();

	@OneToOne(mappedBy = "cartEntity")
	private UserEntity userEntity;

	public CartEntity() {
	}

	public List<CartItemEntity> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItemEntity> cartItems) {
		this.cartItems = cartItems;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public Long getId() {
		return id;
	}

	public void addToCart(CartItemEntity cartItemEntity) {
		cartItems.add(cartItemEntity);
	}

	public void setId(Long id) {
		this.id = id;
	}

}
