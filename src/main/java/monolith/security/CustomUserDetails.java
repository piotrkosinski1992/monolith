package monolith.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import monolith.user.common.api.datatype.Role;
import monolith.user.dataaccess.api.UserEntity;

public class CustomUserDetails extends UserEntity implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public CustomUserDetails(UserEntity user) {
		super(user);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Role> roles = Arrays.asList(super.getRole());
		
		return roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.toString()))
		.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
