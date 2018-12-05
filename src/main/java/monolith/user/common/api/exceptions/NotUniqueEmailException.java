package monolith.user.common.api.exceptions;

public class NotUniqueEmailException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotUniqueEmailException(String errorMessage) {
		super(errorMessage);
	}
	
}
