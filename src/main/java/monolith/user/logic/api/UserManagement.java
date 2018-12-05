package monolith.user.logic.api;

import java.util.List;

import monolith.cart.common.api.exceptions.IdNotFoundException;
import monolith.user.common.api.exceptions.NotUniqueEmailException;
import monolith.user.logic.api.to.UserTO;

public interface UserManagement {

	public List<UserTO> getAllUsers();

	public UserTO getById(Long id) throws IdNotFoundException;
	
	public void addUser(UserTO userTO) throws NotUniqueEmailException;
	
	public void deleteUser(Long id);
	
	public void updateUser(UserTO userTO);
	
	public UserTO findUserByUsername(String username);
	
	public Long getUserIdByUsername(String username);
}
