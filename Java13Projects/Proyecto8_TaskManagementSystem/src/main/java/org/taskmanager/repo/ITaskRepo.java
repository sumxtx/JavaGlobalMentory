package org.taskmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.taskmanager.modelo.Task;

public interface ITaskRepo extends JpaRepository<Task, Integer> {

}

