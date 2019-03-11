package com.registration.mongodb.model;

import javax.validation.constraints.NotEmpty;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
	@Id
	private ObjectId id;
	
	private String name;
	@NotEmpty
	@Indexed(unique = true)
	private String userName;
	@NotEmpty
	private String password;
	
	private String surname;
	
	@NotEmpty
	@Indexed(unique = true)
	private String email;
	
	private int age;

	protected User() {
	}

	public User(String name, String userName, String password, String email, String surname, int age) {
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.surname = surname;
		this.age = age;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
