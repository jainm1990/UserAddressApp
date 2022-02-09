package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class User {
	
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	 @Id
	 @GeneratedValue
	 @Column(name = "userid")
	 private long id;
	    
	 @Column(name = "firstname", nullable = false)
	 private String firstName;
	    
	 @Column(name = "lastname", nullable = false)
	 private String lastName;
	 
	 @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	 Set<Address> address = new HashSet<Address>();

	public Set<Address> getAddress() {
		return address;
	}

	
	 
	 
	
	 

}
