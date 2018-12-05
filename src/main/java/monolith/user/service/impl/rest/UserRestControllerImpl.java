package monolith.user.service.impl.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import monolith.cart.common.api.exceptions.IdNotFoundException;
import monolith.user.common.api.exceptions.NotUniqueEmailException;
import monolith.user.logic.api.UserManagement;
import monolith.user.logic.api.to.UserTO;
import monolith.user.service.api.rest.UserRestController;

@Slf4j
@RestController
public class UserRestControllerImpl implements UserRestController {
	
	@Autowired
	private UserManagement userManagement;

	@Override
	public List<UserTO> getAllUsers() {
		return userManagement.getAllUsers();
	}

	@Override
	public ResponseEntity<UserTO> geUserById(Long id) {
		try {
			return new ResponseEntity<UserTO>(userManagement.getById(id), HttpStatus.OK);
		} catch (IdNotFoundException e) {
			log.error(e.getMessage());
		}
		return new ResponseEntity<UserTO>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<String> addUser(UserTO userTO) {
		try {
			userManagement.addUser(userTO);
			return new ResponseEntity<String>(HttpStatus.CREATED);
		} catch (NotUniqueEmailException e) {
			log.error(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}

	@Override
	public void deleteUserById(Long id) {
		userManagement.deleteUser(id);
	}

	@Override
	public void updateUser(UserTO userTO) {
		userManagement.updateUser(userTO);
	}

}
