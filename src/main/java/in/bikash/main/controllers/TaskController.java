package in.bikash.main.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.bikash.main.TodoListApplication;
import in.bikash.main.entities.Task;
import in.bikash.main.services.TaskService;

@Controller
//@RequestMapping("/tasks")
public class TaskController {

    private final TodoListApplication todoListApplication;

    private final TaskService taskService;

	public TaskController(TaskService taskService, TodoListApplication todoListApplication) {
	
		this.taskService = taskService;
	
		this.todoListApplication = todoListApplication;
	}
	
	@GetMapping
	public String getTasks(Model model) {
		
		List<Task> tasks=taskService.getAllTasks();
		model.addAttribute("tasks",tasks);		
		return"tasks";
	}
	
	@PostMapping
	public String createTask(@RequestParam String title) {
		
		 taskService.createTask(title);		 	
		return"redirect:/";
	}
	
	@GetMapping("/{id}/delete")
	public String deleteTask(@PathVariable Long id) {
		
		taskService.deleteTask(id);
		return "redirect:/";
	 
	}
	
	@GetMapping("/{id}/toggle")
	public String toggleTask(@PathVariable Long id) {
		
		taskService.toggleTask(id);
		return "redirect:/";
	 
	}
	
	

}
