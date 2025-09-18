package com.hr.repo;

import com.hr.modelo.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoEmployee extends JpaRepository<Employee, Integer> {

}
