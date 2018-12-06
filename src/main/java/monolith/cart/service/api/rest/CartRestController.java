package monolith.cart.service.api.rest;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import monolith.cart.logic.api.to.CartItemTO;
import monolith.cart.logic.api.to.CartTO;

@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping("/cart")
public interface CartRestController {

	@PostMapping("/add")
	void addProductToCart(@RequestBody CartItemTO cartItemTO, Principal principal);
	
	@GetMapping("/show/")
	CartTO getCart(Principal principal);
}
