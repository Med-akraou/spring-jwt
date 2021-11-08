package jsf.osf.demo.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jsf.osf.demo.dao.TaskRepositery;
import jsf.osf.demo.entities.Task;
import jsf.osf.demo.services.TaskServise;
@Service
public class TaskServiceImp implements TaskServise {

	@Autowired
	private TaskRepositery taskRepositery;
	@Override
	public List<Task> getTasks() {
		
		return taskRepositery.findAll();
	}

	@Override
	public Task AddTask(Task task) {
		
		return taskRepositery.save(task);
	}

}
