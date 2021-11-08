package jsf.osf.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jsf.osf.demo.dao.TaskRepositery;
import jsf.osf.demo.dao.UserReposetiry;
import jsf.osf.demo.entities.RoleEntity;
import jsf.osf.demo.entities.UserEntity;
import jsf.osf.demo.services.UserService;

@SpringBootApplication
public class JwtSpringApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	
	
	public static void main(String[] args) {
		SpringApplication.run(JwtSpringApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder passWordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	public void run(String... args) throws Exception {
		userService.sauveUser(new UserEntity(null,"user1","1234",null));
		userService.sauveUser(new UserEntity(null,"admin","1234",null));
		userService.sauveRole(new RoleEntity(null,"ADMIN"));
		userService.sauveRole(new RoleEntity(null,"USER"));
		userService.AddRoleToUser("admin", "ADMIN");
		userService.AddRoleToUser("admin", "USER");
		
		System.out.println("roles and users are create succesfly");
		
		
	}
}
