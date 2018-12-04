package monolith.user.logic.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import monolith.cart.common.api.exceptions.IdNotFoundException;
import monolith.user.dataaccess.api.UserEntity;
import monolith.user.dataaccess.api.dao.UserDao;
import monolith.user.logic.api.UserManagement;
import monolith.user.logic.api.to.UserTO;

@Slf4j
@Service
class UserManagementImpl implements UserManagement {

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<UserTO> getAllUsers() {
		return userDao.findAll()
					  .stream()
					  .map(userEntity -> new UserTO(userEntity))
					  .collect(Collectors.toList());
	}

	@Override
	public UserTO getById(Long id){
		UserEntity optionalUser = null;
		try {
			optionalUser = userDao.findById(id).orElseThrow(() -> new IdNotFoundException("No user with id: " + id));
		} catch (IdNotFoundException e) {
			log.info(e.getMessage());
		}
		return new UserTO(optionalUser);
	}

	@Override
	public void addUser(UserTO userTO) {
		userTO.setPassword(passwordEncoder.encode(userTO.getPassword()));
		userDao.save(new UserEntity(userTO));
	}

	@Override
	public void deleteUser(Long id) {
		userDao.deleteById(id);
	}

	@Override
	public void updateUser(UserTO userTO) {
		Optional<UserEntity> optionalUser = userDao.findById(userTO.getId());
		
		if(optionalUser.isPresent()) {
			optionalUser.ifPresent(updatedUser -> {
				updatedUser.setEmail(userTO.getEmail());
				updatedUser.setPassword(passwordEncoder.encode(userTO.getPassword()));
				updatedUser.setRole(userTO.getRole());
				updatedUser.setUsername(userTO.getUsername());
			});
		}
		//will see if need save
		
	}

}
