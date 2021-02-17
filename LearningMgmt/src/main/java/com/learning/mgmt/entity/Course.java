package com.learning.mgmt.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column 
	private int courseId;
	@Column 
	private String courseName;
	@Column 
	private int courseDuration;
	@Column 
	private LocalDateTime startDate;
	@Column 
	private LocalDateTime endDate;
	
	@ManyToOne
	@JoinColumn(name = "categoryId", nullable = false)
	private Category category;
	
	@OneToMany(mappedBy = "course")
	private Set<Enrollment> enrollment;
	
	
}
