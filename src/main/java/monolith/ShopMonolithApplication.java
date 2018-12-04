package monolith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import monolith.user.common.api.datatype.Role;
import monolith.user.dataaccess.api.UserEntity;
import monolith.user.dataaccess.api.dao.UserDao;

@SpringBootApplication
public class ShopMonolithApplication implements CommandLineRunner {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(ShopMonolithApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userDao.save(new UserEntity("piotr",passwordEncoder.encode("kosinski") , Role.USER));
		userDao.save(new UserEntity("admin",passwordEncoder.encode("admin") , Role.ADMIN));
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
}
