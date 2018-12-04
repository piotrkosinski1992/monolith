package monolith.user.service.api.rest;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

import monolith.user.logic.api.to.UserTO;


public interface UserRestController {
		
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/hello")
	public List<UserTO> getAllUsers();
}
