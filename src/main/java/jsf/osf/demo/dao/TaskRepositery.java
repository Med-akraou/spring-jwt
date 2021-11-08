package jsf.osf.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import jsf.osf.demo.entities.Task;

public interface TaskRepositery extends JpaRepository<Task, Long>{
	
}