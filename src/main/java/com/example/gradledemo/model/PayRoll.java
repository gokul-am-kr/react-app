package com.example.gradledemo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PayRoll {
	@Id
private Long id;
private int salary;
public PayRoll(Long id, int salary) {
	super();
	this.id = id;
	this.salary = salary;
}
public Long getId() {
	return id;
}
public PayRoll() {
	super();
}
public void setId(Long id) {
	this.id = id;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}
}
