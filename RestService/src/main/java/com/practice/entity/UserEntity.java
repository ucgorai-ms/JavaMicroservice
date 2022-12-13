package com.practice.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

@Entity(name = "user_details")
public class UserEntity {
	
	@NotBlank(message="Name is Mandatory")
	private String name;
	
	@Id
	@GeneratedValue
	private int id;
	
	@OneToMany(mappedBy = "user")
	private List<PostEntity> posts;
	
	@Past(message = "Date should be past date")
	private LocalDate dateOfBirth;
	
	public UserEntity() {
		
	}
	
	public UserEntity(int id, String name, LocalDate dateOfBirth, List<PostEntity> posts) {
		this.name = name;
		this.id = id;
		this.dateOfBirth = dateOfBirth;
		this.posts = posts;
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

	public List<PostEntity> getPosts() {
		return posts;
	}

	public void setPosts(ArrayList<PostEntity> posts) {
		this.posts = posts;
	}

}
