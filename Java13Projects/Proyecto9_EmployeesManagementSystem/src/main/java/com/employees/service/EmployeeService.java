package com.employees.service;

import com.employees.modelo.Employee;
import com.employees.repositorio.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{

    @Autowired
    private IEmployeeRepo employeeRepo;

    @Override
    public List<Employee> listEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee findEmployeeById(Integer idEmployee) {
        Employee employee = employeeRepo.findById(idEmployee).orElse(null);
        return employee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepo.delete(employee);
    }
}
