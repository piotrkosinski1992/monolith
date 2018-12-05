package monolith.cart.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import monolith.cart.logic.api.to.CartItemTO;
import monolith.cart.logic.api.to.CartTO;
import monolith.product.dataaccess.api.ProductEntity;

@Entity
public class CartItemEntity {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private ProductEntity productEntity;
	
	private int amount;
	
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private CartEntity cartEntity;

	public CartItemEntity() {
	}

	public ProductEntity getProductEntity() {
		return productEntity;
	}

	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
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

	public CartEntity getCartEntity() {
		return cartEntity;
	}

	public void setCartEntity(CartEntity cartEntity) {
		this.cartEntity = cartEntity;
	}	
	
	
}
