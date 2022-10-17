package com.me.shopify.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_table")
public class User {
	 @Id 
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="id", unique = true, nullable = false)
	 private long id;
	 
	 @Column(name="name")
	 private String name;
	 
	 @Column(name = "userEmail")
	 private String userEmail;
	 
	 @Column(name = "password")
	 private String password;
	 
	 @Column(name="address")
	 private String address;
	 
	 @Column(name="number")
	 private String number;
	 
	 @Column(name="status")
	 private int status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	 
	 
}
