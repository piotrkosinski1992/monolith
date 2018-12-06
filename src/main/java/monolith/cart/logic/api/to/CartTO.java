package monolith.cart.logic.api.to;

import java.util.ArrayList;
import java.util.List;

import monolith.cart.dataaccess.api.CartItemEntity;
import monolith.user.dataaccess.api.UserEntity;

public class CartTO {

	private Long id;
	
	private List<CartItemTO> cartItems = new ArrayList<>();
	
	public CartTO() {
	}

	public List<CartItemTO> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItemTO> cartItems) {
		this.cartItems = cartItems;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
