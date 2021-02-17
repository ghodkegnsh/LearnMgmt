package com.learning.mgmt.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int userId;
	@Column
	private String userName;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String password;
	@Column
	private String emailId;
	
	@OneToMany(mappedBy = "user")
	private Set<Enrollment> enrollment;
	
	
	public User() {
		super();

	}
	
	
	
	
	
}
