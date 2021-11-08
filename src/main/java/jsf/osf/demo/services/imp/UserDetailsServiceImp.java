package jsf.osf.demo.services.imp;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jsf.osf.demo.entities.UserEntity;
import jsf.osf.demo.services.UserService;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

	@Autowired
	private UserService userService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		UserEntity u= userService.findUserByUsername(username);
		
		if(u==null) 
			{System.out.println("mal9inah");
			throw new UsernameNotFoundException("user not found ?!!?");
			}
		
		Collection<GrantedAuthority> authorities= new ArrayList<>();
		u.getRoles().forEach(r->{
			authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
		});
		return new User(u.getUsername(),u.getPassword(),authorities);
	}

}
