package monolith.cart.service.impl.rest;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import monolith.cart.logic.api.CartManagement;
import monolith.cart.logic.api.to.CartItemTO;
import monolith.cart.service.api.rest.CartRestController;

@RestController
public class CartRestControllerImpl implements CartRestController {

	@Autowired
	private CartManagement cartManagement;
	
	
	
	//TODO dostac id usera zamiast username
	@Override
	public void addProductToCart(CartItemTO cartItemTO, Principal principal) {
		cartManagement.addToCart(cartItemTO, principal.getName());
		
	}
}
