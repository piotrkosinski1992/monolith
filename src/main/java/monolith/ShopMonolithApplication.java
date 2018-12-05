package monolith;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import monolith.product.dataaccess.api.ProductEntity;
import monolith.product.dataaccess.api.dao.ProductDao;
import monolith.user.common.api.datatype.Role;
import monolith.user.logic.api.UserManagement;
import monolith.user.logic.api.to.UserTO;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class ShopMonolithApplication implements CommandLineRunner {

	@Autowired
	private UserManagement userManagement;
	
	@Autowired
	private ProductDao productDao;
	
	public static void main(String[] args) {
		SpringApplication.run(ShopMonolithApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userManagement.addUser(new UserTO("user","user" , Role.USER, "piotrkosinski1992@o2.pl"));
		userManagement.addUser(new UserTO("admin","admin" , Role.ADMIN, "natasza13@vp.pl"));
		
		productDao.save(new ProductEntity("ferrari", "auto", "szybkie auto"));
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}
