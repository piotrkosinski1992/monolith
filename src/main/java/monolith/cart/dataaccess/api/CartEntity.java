package monolith.cart.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CartEntity {

	@Id
	@GeneratedValue
	private Long id;

	public CartEntity() {
	}
	
}
