package jsf.osf.demo.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jsf.osf.demo.dao.RoleReposetity;
import jsf.osf.demo.dao.UserReposetiry;
import jsf.osf.demo.entities.RoleEntity;
import jsf.osf.demo.entities.UserEntity;
import jsf.osf.demo.services.UserService;

@Service
@Transactional
public class UserServiceImp implements UserService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserReposetiry userReposetiry;
	@Autowired
	private RoleReposetity roleReposetity;
	
	@Override
	public UserEntity sauveUser(UserEntity u) {
		UserEntity check=userReposetiry.findByUsername(u.getUsername());
		if(check!=null)
			throw new RuntimeException("user already exists");
		u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
		return userReposetiry.save(u);
	}

	@Override
	public RoleEntity sauveRole(RoleEntity r) {
		// TODO Auto-generated method stub
		return roleReposetity.save(r);
	}

	@Override
	public void AddRoleToUser(String username, String roleName) {
	UserEntity user=userReposetiry.findByUsername(username);
	RoleEntity role=roleReposetity.findByRoleName(roleName);
	
	user.getRoles().add(role);
		
	}

	@Override
	public UserEntity findUserByUsername(String usename) {
		return userReposetiry.findByUsername(usename);
	}

	

}
