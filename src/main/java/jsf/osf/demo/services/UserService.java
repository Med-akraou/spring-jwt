package jsf.osf.demo.services;

import jsf.osf.demo.entities.RoleEntity;
import jsf.osf.demo.entities.UserEntity;

public interface UserService {
	public UserEntity sauveUser(UserEntity u);
	public RoleEntity sauveRole(RoleEntity r);
	public void AddRoleToUser(String username,String role);
	public UserEntity findUserByUsername(String usename);

}
