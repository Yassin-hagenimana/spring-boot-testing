package com.example.springboottesting.services;

import com.example.springboottesting.dto.CreateEmployee;
import com.example.springboottesting.dto.UpdateEmployee;
import com.example.springboottesting.models.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
  List<Employee> findAll();
  Employee findById(Long id);
  Employee addEmployee(CreateEmployee createEmployee);
  Employee changeEmployee(UpdateEmployee updateEmployee, Long id);
  boolean DeleteEmployee(Long id);
}
