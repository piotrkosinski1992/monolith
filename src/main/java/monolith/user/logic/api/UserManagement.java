package monolith.user.logic.api;

import java.util.List;

import monolith.user.logic.api.to.UserTO;

public interface UserManagement {

	public List<UserTO> getAllUsers();

	public UserTO getById(Long id);
	
	public void addUser(UserTO userTO);
	
	public void deleteUser(Long id);
	
	public void updateUser(UserTO userTO);
}
