package monolith.cart.logic.api.to;

import monolith.product.logic.api.to.ProductTO;

public class CartItemTO {
	
	private Long id;
		
	private ProductTO productTO;
	
	private int amount;
	
	private CartTO cartTO;

	public CartItemTO() {
	}

	public ProductTO getProductTO() {
		return productTO;
	}

	public void setProductTO(ProductTO productTO) {
		this.productTO = productTO;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public CartTO getCartTO() {
		return cartTO;
	}

	public void setCartTO(CartTO cartTO) {
		this.cartTO = cartTO;
	}

	
}
