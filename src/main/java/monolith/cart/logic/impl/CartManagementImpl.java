package monolith.cart.logic.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import monolith.cart.common.api.Mapper;
import monolith.cart.dataaccess.api.CartEntity;
import monolith.cart.dataaccess.api.CartItemEntity;
import monolith.cart.dataaccess.api.dao.CartDao;
import monolith.cart.logic.api.CartManagement;
import monolith.cart.logic.api.to.CartItemTO;
import monolith.cart.logic.api.to.CartTO;
import monolith.product.dataaccess.api.ProductEntity;
import monolith.user.logic.api.UserManagement;

@Service
public class CartManagementImpl implements CartManagement {

	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private UserManagement userManagement;
	
	@Override
	public CartEntity createCart() {
		return new CartEntity();
	}

	@Override
	public void addToCart(CartItemTO cartItemTO, String username) {
		CartEntity userCart = cartDao.findByUserEntityId(userManagement.getUserIdByUsername(username));
		
		if(productAlreadyInCart(userCart.getCartItems(),cartItemTO.getProductTO().getId())) {
			userCart.getCartItems().forEach(cartItemEntity -> {
				if(cartItemEntity.getProductEntity().getId() == cartItemTO.getProductTO().getId()) {
					cartItemEntity.setAmount(cartItemEntity.getAmount() + cartItemTO.getAmount());
				}
			});
		} else {
			CartItemEntity cartItemEntity = Mapper.convertToCartItemEntity(cartItemTO);
			
			cartItemEntity.setCartEntity(userCart);
			userCart.addToCart(cartItemEntity);
		}

		cartDao.save(userCart);
		//dodanie inventory
		//sprawdzanie czy mozna dodac tyle itemow do koszyka
	}


	private boolean productAlreadyInCart(List<CartItemEntity> cartItems, Long id) {
		for(CartItemEntity cartItemEntity : cartItems) {
			if(cartItemEntity.getProductEntity().getId() == id) {
				return true;
			}
		}
		return false;
	}

	@Override
	public CartTO getCart(String username) {
		CartEntity userCart = cartDao.findByUserEntityId(userManagement.getUserIdByUsername(username));
		
		List<CartItemTO> cartItemTOs = userCart.getCartItems()
											   .stream()
											   .map(cartItemEntity -> Mapper.convertToCartItemTO(cartItemEntity))
											   .collect(Collectors.toList());
			
		
		CartTO userCartTO = Mapper.convertToTO(userCart, CartTO.class);
		
		userCartTO.setCartItems(cartItemTOs);
		
		return userCartTO;
	}
}
