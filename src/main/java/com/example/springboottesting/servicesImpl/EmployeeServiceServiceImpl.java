package com.example.springboottesting.servicesImpl;

import com.example.springboottesting.dto.CreateEmployee;
import com.example.springboottesting.dto.UpdateEmployee;
import com.example.springboottesting.exceptions.EmployeeException;
import com.example.springboottesting.models.Employee;
import com.example.springboottesting.repository.EmployeeRepository;
import com.example.springboottesting.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;
  @Override
  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee findById(Long id) {
    Optional<Employee>findEmployee=employeeRepository.findById(id);
    if (findEmployee.isEmpty())
      throw new  EmployeeException("Employee with this id  not found");
    return findEmployee.get();
  }

  @Override
  public Employee addEmployee(CreateEmployee createEmployee) {
    Employee newEmployee=new Employee(
        createEmployee.getNames(),
        createEmployee.getSalary(),
        createEmployee.getTitle(),
        createEmployee.getLocation()
    );

    return employeeRepository.save(newEmployee);
  }

  @Override
  public Employee changeEmployee(UpdateEmployee updateEmployee, Long id) {
    Optional<Employee>findEmployee=employeeRepository.findById(id);
    if (findEmployee.isEmpty())
      throw new  EmployeeException("Employee with this id  not found");

    Employee updatedEmployee=new Employee(
      updateEmployee.getNames(),
      updateEmployee.getSalary(),
      updateEmployee.getTitle(),
      updateEmployee.getLocation()
    );
    updatedEmployee.setId(id);
    return employeeRepository.save(updatedEmployee);
  }

  @Override
  public boolean DeleteEmployee(Long id) {
    Optional<Employee>findEmployee=employeeRepository.findById(id);
    if (findEmployee.isEmpty())
      throw new  EmployeeException("Employee with this id  not found");
    employeeRepository.deleteById(id);
    return true;
  }
}
