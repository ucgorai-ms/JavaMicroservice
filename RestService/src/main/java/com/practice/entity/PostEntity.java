package com.practice.entity;


import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;

@Entity(name="post_details")
public class PostEntity {
	
	@Id
	@GeneratedValue
	private int Id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private UserEntity user;
	
	private String postDetails;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getPostDetails() {
		return postDetails;
	}

	public void setPostDetails(String postDetails) {
		this.postDetails = postDetails;
	}

	@Override
	public String toString() {
		return "PostEntity [Id=" + Id + ", user=" + user + ", postDetails=" + postDetails + "]";
	}

}
