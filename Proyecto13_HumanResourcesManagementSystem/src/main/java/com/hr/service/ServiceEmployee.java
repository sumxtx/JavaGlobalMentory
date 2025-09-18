package com.hr.service;

import com.hr.modelo.Employee;
import com.hr.repo.RepoEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceEmployee implements IServiceEmployee{
    @Autowired
    private RepoEmployee repoEmployee;

    @Override
    public List<Employee> listEmployees() {
        return repoEmployee.findAll();
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        Employee employee = repoEmployee.findById(id).orElse(null);
        return employee;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return repoEmployee.save(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        repoEmployee.delete(employee);
    }
}
