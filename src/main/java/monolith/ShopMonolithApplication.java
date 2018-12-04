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
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
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
		userDao.save(new UserEntity("piotr",passwordEncoder.encode("kosinski") , Role.USER, "piotrkosinski1992@o2.pl"));
		userDao.save(new UserEntity("admin",passwordEncoder.encode("admin") , Role.ADMIN, "natasza13@vp.pl"));
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
}
