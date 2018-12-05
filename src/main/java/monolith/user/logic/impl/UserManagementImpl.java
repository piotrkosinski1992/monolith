package monolith.user.logic.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import monolith.cart.common.api.Mapper;
import monolith.cart.common.api.exceptions.IdNotFoundException;
import monolith.cart.logic.api.CartManagement;
import monolith.user.common.api.datatype.Role;
import monolith.user.common.api.exceptions.NotUniqueEmailException;
import monolith.user.dataaccess.api.UserEntity;
import monolith.user.dataaccess.api.dao.UserDao;
import monolith.user.logic.api.UserManagement;
import monolith.user.logic.api.to.UserTO;

@Service
public class UserManagementImpl implements UserManagement {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CartManagement cartManagement;

	@Override
	public List<UserTO> getAllUsers() {
		
		return userDao.findAll().stream().map(userEntity -> Mapper.convertToTO(userEntity, UserTO.class)).collect(Collectors.toList());
	}

	@Override
	public UserTO getById(Long id) throws IdNotFoundException {

		UserEntity optionalUser = userDao.findById(id).orElseThrow(() -> new IdNotFoundException("No user with id: " + id));

		return Mapper.convertToTO(optionalUser, UserTO.class);
	}

	@Override
	public void addUser(UserTO userTO) throws NotUniqueEmailException {
		isEmailExistsInDatabase(userTO.getEmail());
		
		userTO.setCartEntity(cartManagement.createCart());
		userTO.setPassword(passwordEncoder.encode(userTO.getPassword()));
		userDao.save(Mapper.convertToEntity(userTO, UserEntity.class));
	}

	@Override
	public void deleteUser(Long id) {
		userDao.deleteById(id);
	}

	@Override
	public void updateUser(UserTO userTO) {
		
		Optional<UserEntity> optionalUser = userDao.findById(userTO.getId());

		if (optionalUser.isPresent()) {
			optionalUser.ifPresent(updatedUser -> {
				
				if(!updatedUser.getEmail().equals(userTO.getEmail())) {
					if(userDao.findByEmail(userTO.getEmail()).isPresent()) {
						return;
					}
				}
				updatedUser.setEmail(userTO.getEmail());
				updatedUser.setPassword(passwordEncoder.encode(userTO.getPassword()));
				updatedUser.setRole(userTO.getRole());
				updatedUser.setUsername(userTO.getUsername());
				
				userDao.save(updatedUser);
				//TODO
				//potrzebny save
				//dublowany email przechwycony ale brak komunikatu do frontu
			});
		}
	}
	
	private boolean isEmailExistsInDatabase(String email) throws NotUniqueEmailException {
		if (userDao.findByEmail(email).isPresent()) {
			throw new NotUniqueEmailException("email already exists in database");
		}
		
		return true;
	}

	@Override
	public UserTO findUserByUsername(String username) {
		
		UserEntity userEntity = userDao.findByUsername(username)
								 .orElseThrow(() -> new UsernameNotFoundException("User with username: " + username + " not found"));
		
		return Mapper.convertToTO(userEntity, UserTO.class);
	}

	@Override
	public Long getUserIdByUsername(String username) {
		UserEntity userEntity = userDao.findByUsername(username)
				 .orElseThrow(() -> new UsernameNotFoundException("User with username: " + username + " not found"));
		
		return userEntity.getId();
	}


}
