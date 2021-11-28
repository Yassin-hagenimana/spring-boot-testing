package com.example.springboottesting.controllers;

import com.example.springboottesting.dto.CreateEmployee;
import com.example.springboottesting.dto.UpdateEmployee;
import com.example.springboottesting.models.Employee;
import com.example.springboottesting.servicesImpl.EmployeeServiceServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import java.util.List;

@RequestMapping("/api/employees")
@RestController
@CrossOrigin
public class EmployeeController {
  private EmployeeServiceServiceImpl employeeServiceService;

  @GetMapping
  public List<Employee>findAll(){
    return employeeServiceService.findAll();
  }
  @GetMapping("/{id}")
  public Employee find(@PathVariable Long id){
    return employeeServiceService.findById(id);
  }
  @PostMapping
  public ResponseEntity<?>save(@RequestBody CreateEmployee createEmployee){
    Employee saveEmployee=employeeServiceService.addEmployee(createEmployee);
    return ResponseEntity.ok(saveEmployee);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?>update(@RequestBody UpdateEmployee updateEmployee,@PathVariable  Long id){
    Employee updatedEmployee=employeeServiceService.changeEmployee(updateEmployee,id);

    return ResponseEntity.ok(updatedEmployee);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?>delete(@PathVariable Long id){
    Boolean deleted=employeeServiceService.DeleteEmployee(id);
    return ResponseEntity.ok(deleted);

  }
}
