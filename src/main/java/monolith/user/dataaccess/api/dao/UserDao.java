package monolith.user.dataaccess.api.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import monolith.user.dataaccess.api.UserEntity;

public interface UserDao extends JpaRepository<UserEntity, Long> {
	
	Optional<UserEntity> findByUsername(String username);
	
	Optional<UserEntity> findByEmail(String email);

}
