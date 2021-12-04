package tech.grtarrays.employeemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.grtarrays.employeemanager.Service.EmployeeService;
import tech.grtarrays.employeemanager.model.Employee;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    public final EmployeeService employeeService;

    @Autowired
    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) throws Throwable {
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping ("/add")
    public ResponseEntity<Employee> addEmployee( @RequestBody Employee employee) {
   System.out.println("inside add call in controller");
    Employee newEmployee = employeeService.addEmployee(employee);
        System.out.println("inside add call in controller after service call");
    return  new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
    }

    @PutMapping ("/update")
    public ResponseEntity<Employee> UpdateEmployee(@RequestBody Employee employee) {
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return  new ResponseEntity<>(updateEmployee,HttpStatus.OK);
    }
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
       employeeService.deleteEmployee(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}


