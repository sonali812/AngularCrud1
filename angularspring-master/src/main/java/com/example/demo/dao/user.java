package com.example.demo.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity 
@Table(name="userinfo")
public class user {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="email")
	@NotNull
	@NotEmpty
	@Email
	private String email;
	@Column(name="firstname")
	@NotEmpty
	private String firstname;
	@Column(name="lastname")
	@NotEmpty
	private String lastname;
	@NotEmpty
	@Column(name="age")
	private int age;
	
	
	public user() {}
	
	
	
	public user(@NotNull @NotEmpty @Email String email, @NotEmpty String firstname, @NotEmpty String lastname,
			@NotEmpty int age) {
		super();
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}



	public static user findByEmail(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
