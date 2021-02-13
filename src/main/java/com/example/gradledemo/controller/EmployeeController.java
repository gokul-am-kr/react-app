package com.example.gradledemo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.gradledemo.exception.EmployeeNotFoundException;
import com.example.gradledemo.model.Employee;
import com.example.gradledemo.repository.EmployeeRepository;

@RestController
class EmployeeController {

  private final EmployeeRepository repository;

  EmployeeController(EmployeeRepository repository) {
    this.repository = repository;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping("/employees")
  List<Employee> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/employees")
  Employee newEmployee(@RequestBody Employee newEmployee) {
    return repository.save(newEmployee);
  }

  // Single item

  @GetMapping("/employees/{id}")
  Employee one(@PathVariable Long id) {

    return repository.findById(id)
      .orElseThrow(() -> new EmployeeNotFoundException(id));
  }
  
//  @GetMapping("/employeesname")
//  List<OrderResponse> onet() {
//
//    return repository.getJoinInfo();}
//  
//  
//  @GetMapping("/active/{id}")
//  List<Employee> active(@PathVariable Long id) {
//	  boolean status = false;
//	  if(id==1) {
//		  status = true;
//	  }
//
//    return repository.findActiveEmployees(status);
//  }

//  @PutMapping("/employees/{id}")
//  Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
//
//    return repository.findById(id)
//      .map(employee -> {
//        employee.setName(newEmployee.getName());
//        employee.setRole(newEmployee.getRole());
//        return repository.save(employee);
//      })
//      .orElseGet(() -> {
//        newEmployee.setId(id);
//        return repository.save(newEmployee);
//      });
//  }
  
  

  @DeleteMapping("/employees/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
  }
}