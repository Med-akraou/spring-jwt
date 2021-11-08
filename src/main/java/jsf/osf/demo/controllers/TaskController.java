package jsf.osf.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jsf.osf.demo.entities.Task;
import jsf.osf.demo.services.TaskServise;


@RestController
public class TaskController{
	
	@Autowired
	private TaskServise taskServise;
	
	@GetMapping(path="/")
	private String home() {
		return "hello world";

	}

	@GetMapping(path = "/tasks")
	public List<Task> listTasks(){
		return taskServise.getTasks();
	}
	
	@PostMapping(path = "/addTask")
	public Task sauve(@RequestBody Task t) {
		return taskServise.AddTask(t);
	}
	
	
	
	
}