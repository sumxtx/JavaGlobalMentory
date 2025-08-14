package com.employees.service;

import com.employees.modelo.Employee;
import java.util.List;

public interface IEmployeeService {
    public List<Employee> listEmployee();
    public Employee findEmployeeById(Integer idEmployee);
    public void saveEmployee(Employee employee);
    public void deleteEmployee(Employee employee);

}
