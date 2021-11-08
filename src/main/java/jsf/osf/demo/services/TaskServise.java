package jsf.osf.demo.services;

import java.util.List;

import jsf.osf.demo.entities.Task;

public interface TaskServise {

	public List<Task> getTasks();
	public Task AddTask(Task task);
}
