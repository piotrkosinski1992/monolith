package monolith.cart.logic.api.to;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import monolith.cart.common.api.Mapper;
import monolith.cart.dataaccess.api.CartEntity;
import monolith.user.logic.api.to.UserTO;

public class CartTO {

	private Long id;
	
	private List<CartItemTO> cartItems = new ArrayList<>();
	
	private UserTO userTO;
	
	public List<CartItemTO> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItemTO> cartItems) {
		this.cartItems = cartItems;
	}

	public UserTO getUserTO() {
		return userTO;
	}

	public void setUserTO(UserTO userTO) {
		this.userTO = userTO;
	}

	public Long getId() {
		return id;
	}
	
}
