package com.practice.bean;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;



public class UserBean {
	
	@NotBlank(message="Name is Mandatory")
	private String name;
	private int id;
	@Past(message = "Date should be past date")
	private LocalDate dateOfBirth;
	
	public UserBean(int id, String name, LocalDate dateOfBirth) {
		//super();
		this.name = name;
		this.id = id;
		this.dateOfBirth = dateOfBirth;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "UserBean [name=" + name + ", id=" + id + ", dateOfBirth=" + dateOfBirth + "]";
	}

}
