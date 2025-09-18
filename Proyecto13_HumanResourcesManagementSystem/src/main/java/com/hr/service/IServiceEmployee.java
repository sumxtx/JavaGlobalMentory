package com.hr.service;
import com.hr.modelo.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IServiceEmployee {
    public List<Employee> listEmployees();
    public Employee findEmployeeById(Integer id);
    public Employee saveEmployee(Employee employee);
    public void deleteEmployee(Employee employee);
}
