package monolith.cart.common.api.exceptions;

public class IdNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public IdNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
