package com.apidemo.controller;

import com.apidemo.payload.EmployeeDto;
import com.apidemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/empreg")
public class EmployeeController {

    // Constructor based Dependency Injection
    private EmployeeService empService;

    public EmployeeController(EmployeeService empService) {
        this.empService = empService;
    }

    //http://localhost:8081/api/v1/empregistration

    @PostMapping
    public String registerEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto empDto = empService.createEmpRegistration(employeeDto);
        return "Employee registered successfully with ID:" + empDto.getId();
    }

    // Add methods to handle HTTP requests here
    @DeleteMapping
    public String deleteEmployee(@RequestParam long id) {
        empService.deleteEmployee(id);
        return "Employee deleted successfully with ID:" + id;
    }

}
