package monolith.cart.logic.api;

import javax.transaction.Transactional;

import monolith.cart.dataaccess.api.CartEntity;
import monolith.cart.logic.api.to.CartItemTO;
import monolith.cart.logic.api.to.CartTO;

public interface CartManagement {

	public CartEntity createCart();
	
	@Transactional
	void addToCart(CartItemTO cartItemTO, String username);
	
	CartTO getCart(String username);
}
