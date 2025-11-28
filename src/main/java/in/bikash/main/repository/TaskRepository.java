package in.bikash.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.bikash.main.entities.Task;

public interface TaskRepository  extends JpaRepository<Task, Long>{
	
	

}
