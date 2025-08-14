package com.employees.repositorio;

import com.employees.modelo.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepo extends JpaRepository<Employee, Integer> {
}
