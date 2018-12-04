package monolith.user.service.impl.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import monolith.user.dataaccess.api.dao.UserDao;
import monolith.user.logic.api.to.UserTO;
import monolith.user.service.api.rest.UserRestController;

@RestController
public class UserRestControllerImpl implements UserRestController {

	@Autowired
	private UserDao userDao;

	@Override
	public List<UserTO> getAllUsers() {
		return userDao.findAll()
					  .stream()
					  .map(userEntity -> new UserTO(userEntity))
					  .collect(Collectors.toList());
					  

	}

}
