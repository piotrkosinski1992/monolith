package monolith.user.service.impl.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import monolith.user.logic.api.UserManagement;
import monolith.user.logic.api.to.UserTO;
import monolith.user.service.api.rest.UserRestController;

@RestController
public class UserRestControllerImpl implements UserRestController {
	
	@Autowired
	private UserManagement userManagement;

	@Override
	public List<UserTO> getAllUsers() {
		return userManagement.getAllUsers();
	}

	@Override
	public UserTO geUserById(Long id) {
		return userManagement.getById(id);
	}

	@Override
	public void addUser(UserTO userTO) {
		userManagement.addUser(userTO);	
	}

	@Override
	public void deleteUserById(Long id) {
		userManagement.deleteUser(id);
	}

	@Override
	public void updateUser(UserTO userTO) {
		// TODO Auto-generated method stub
		
	}

}
