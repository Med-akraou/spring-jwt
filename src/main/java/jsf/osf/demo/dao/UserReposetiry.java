package jsf.osf.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import jsf.osf.demo.entities.UserEntity;

public interface UserReposetiry extends JpaRepository<UserEntity, Long> {

	public UserEntity findByUsername(String username);
}
