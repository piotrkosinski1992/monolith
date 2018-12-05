package monolith.user.service.api.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import monolith.user.logic.api.to.UserTO;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/user")
public interface UserRestController {
		
	@GetMapping("/all")
	public List<UserTO> getAllUsers();
	
	@GetMapping("/{id}")
	public ResponseEntity<UserTO> geUserById(@PathVariable Long id);
	
	@PostMapping("/add")
	public ResponseEntity<String> addUser(@RequestBody @Valid UserTO userTO);
	
	@DeleteMapping("/delete/{id}")
	public void deleteUserById(@PathVariable Long id);
	
	@PutMapping("/update")
	public void updateUser(@RequestBody UserTO userTO);
}
