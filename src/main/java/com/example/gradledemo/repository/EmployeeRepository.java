package com.example.gradledemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gradledemo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}