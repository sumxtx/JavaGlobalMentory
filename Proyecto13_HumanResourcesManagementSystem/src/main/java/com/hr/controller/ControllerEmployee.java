package com.hr.controller;

import com.hr.exception.ResourceNotFoundException;
import com.hr.modelo.Employee;
import com.hr.service.IServiceEmployee;
import com.hr.service.ServiceEmployee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("hr-app") //localhost:8080/hr-app/employees/id
@CrossOrigin(value="http://localhost:3000") //Accept Request from Front
public class ControllerEmployee {
    private static final Logger logger = LoggerFactory.getLogger(ControllerEmployee.class);

    @Autowired
    private IServiceEmployee employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        var employees = employeeService.listEmployees();
        employees.forEach((employee -> logger.info(employee.toString())));
        return employees;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        logger.info("Employee to add: " + employee);
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id){
        employeeService.findEmployeeById(id);
        Employee employee = employeeService.findEmployeeById(id);
        if(employee == null){
            throw new ResourceNotFoundException("Not found id: " + id);
        }
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee receivedEmployee){
        Employee employee = employeeService.findEmployeeById(id);
        if(employee == null)
            throw new ResourceNotFoundException("The received Id does not Exist: " + id);

        employee.setEmployeeName(receivedEmployee.getEmployeeName());
        employee.setEmployeeDpt(receivedEmployee.getEmployeeDpt());
        employee.setEmployeeSalary(receivedEmployee.getEmployeeSalary());
        employeeService.saveEmployee(employee);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Integer id){
        Employee employee = employeeService.findEmployeeById(id);
        if(employee == null)
            throw new ResourceNotFoundException("The received id does not exist: " + id);

        employeeService.deleteEmployee(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity .ok(response);
    }


}
