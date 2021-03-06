package com.student.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@JsonPropertyOrder({"firstName","email"})
@JsonIgnoreProperties({"lastName","password","confirmPassword","gender","mobile"})

public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Pattern(regexp="[A-Za-z]{3}[A-Za-z]*")
	private String firstName;
	private String lastName;
	@Pattern(regexp="[a-zA-z][a-zA-Z0-9_.]*@[a-zA-Z]+([.][a-zA-Z]+)+")
	private String email;
	@Size(min = 6,max = 15/*, message = "Please enter password in between {min} to {max} chracter"*/)
	private String password;
	@Transient
	private String confirmPassword;
	private Date dob;
	private String gender;
	//@Pattern(regexp="(0|91)?[6-9][0-9]{9}")
	private long mobile;
	
	/*@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private Address address;*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	/*public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}*/

}
