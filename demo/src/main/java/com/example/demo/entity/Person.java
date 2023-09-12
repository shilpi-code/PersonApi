package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Person {

	@Id
	private Integer id;
	@NotEmpty
	private String name;
	private Boolean taskAssigned;
	private Boolean isEmployee;

	public Boolean getTaskAssigned() {
		return taskAssigned;
	}

	public void setTaskAssigned(Boolean taskAssigned) {
		this.taskAssigned = taskAssigned;
	}

	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Person(int id, String name, Boolean taskAssigned) {
		super();
		this.taskAssigned = taskAssigned;
	}

	public Person(int id, String name, Boolean taskAssigned, Boolean isEmployee) {
		super();
		this.isEmployee = isEmployee;
	}

	public Person() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Boolean getIsEmployee() {
		return isEmployee;
	}

	public void setIsEmployee(Boolean isEmployee) {
		this.isEmployee = isEmployee;
	}
}
