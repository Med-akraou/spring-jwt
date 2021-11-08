package jsf.osf.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jsf.osf.demo.entities.UserEntity;
import jsf.osf.demo.services.UserService;

@RestController

public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public UserEntity addUser(@RequestBody RegesterForm userform) {
		
		if(!userform.getPassword().equals(userform.getRepassword()))
			throw new RuntimeException("you must confirm password");
		
		
		UserEntity user=new UserEntity();
		user.setUsername(userform.getUsername());
		user.setPassword(userform.getPassword());
		userService.sauveUser(user);
		userService.AddRoleToUser(user.getUsername(), "USER");
		return user;
	}
	
	
}
