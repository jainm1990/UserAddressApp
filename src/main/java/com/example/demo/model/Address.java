package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	 @Id
	 @GeneratedValue
	 private long id;
	    
	 @Column(name = "address", nullable = false)
	 private String address;
	 
	 @ManyToOne
	 @JoinColumn(name ="user_id")
	 private User user;

	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + address + ", user=" + user + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
