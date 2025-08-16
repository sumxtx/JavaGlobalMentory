package com.employees.controller;

import com.employees.modelo.Employee;
import com.employees.service.EmployeeService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.ref.ReferenceQueue;
import java.util.List;

@Controller
public class IndexController {
   private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

   @Autowired
   EmployeeService employeeService;

   @RequestMapping(value="/", method = RequestMethod.GET)
   public String init(ModelMap modelo){
       List<Employee> employees = employeeService.listEmployee();
       employees.forEach((employee) -> logger.info(employee.toString()));
       modelo.put("employees", employees);
       return "index";
   }

   @RequestMapping(value="/add", method=RequestMethod.GET)
   public String showAdd(){
       return "add";
   }

   @RequestMapping(value="/add", method = RequestMethod.POST)
   public String add(@ModelAttribute("employeeForm") Employee employee, HttpServletRequest request){
       logger.info("Employee Added: " + employee);
        employeeService.saveEmployee(employee);
        return "redirect:/";
   }

   @RequestMapping(value="/edit", method = RequestMethod.GET)
    public String showEdit(@RequestParam int idEmployee, ModelMap modelo){
        Employee employee = employeeService.findEmployeeById(idEmployee);
        logger.info("Editing Employee" + employee);
        modelo.put("employee", employee);
        return "edit";
   }

   @RequestMapping(value = "/edit", method = RequestMethod.POST)
   public String edit(@ModelAttribute("employeeForm") Employee employee){
        logger.info("Employee To Save: " + employee);
        employeeService.saveEmployee(employee);
        return "redirect:/";
   }

   @RequestMapping(value ="/delete", method = RequestMethod.GET)
    public String delete(@RequestParam int idEmployee){
       Employee employee = new Employee();
       employee.setIdEmployee(idEmployee);
       employeeService.deleteEmployee(employee);
       return "redirect:/";
   }
}
