package com.hr.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rh-app") //localhost:8080/hr-app/employees/id
@CrossOrigin //Accept Request from Front
public class ControllerEmployee {
}
