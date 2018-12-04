package monolith.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import monolith.user.dataaccess.api.UserEntity;
import monolith.user.dataaccess.api.dao.UserDao;

@Service
class CustomAccountDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<UserEntity> optionalUser = userDao.findByUsername(username);
		
		UserEntity user = optionalUser.orElseThrow(() -> new UsernameNotFoundException("username not found"));
		
		return new CustomUserDetails(user);
	}

}
