package monolith.cart.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import monolith.cart.common.api.Mapper;
import monolith.cart.dataaccess.api.CartEntity;
import monolith.cart.dataaccess.api.CartItemEntity;
import monolith.cart.dataaccess.api.dao.CartDao;
import monolith.cart.logic.api.CartManagement;
import monolith.cart.logic.api.to.CartItemTO;
import monolith.cart.logic.api.to.CartTO;
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
		cartItemTO.setCartTO(Mapper.convertToTO(userCart, CartTO.class));
		userCart.addToCart(Mapper.convertToEntity(cartItemTO, CartItemEntity.class));
		
		cartDao.save(userCart);
		
	}

	@Override
	public CartTO getCart(String username) {
		CartEntity userCart = cartDao.findByUserEntityId(userManagement.getUserIdByUsername(username));
		
		return Mapper.convertToTO(userCart, CartTO.class);
	}
}
