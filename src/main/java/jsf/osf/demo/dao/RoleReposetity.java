package jsf.osf.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import jsf.osf.demo.entities.RoleEntity;

public interface RoleReposetity extends JpaRepository<RoleEntity, Long>{
public RoleEntity findByRoleName(String role);
}
