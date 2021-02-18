package com.learning.mgmt.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Enrollment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int enrollId;
	@Column
	private LocalDateTime enrollmentDate;
	@Column
	private String status;

	@ManyToOne
	@JoinColumn(name = "userId", nullable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "courseId", nullable = false)
	private Course course;

	public Enrollment() {
		super();

	}

	public Enrollment(int enrollId, LocalDateTime enrollmentDate, String status, User user, Course course) {
		super();
		this.enrollId = enrollId;
		this.enrollmentDate = enrollmentDate;
		this.status = status;
		this.user = user;
		this.course = course;
	}

	public int getEnrollId() {
		return enrollId;
	}

	public void setEnrollId(int enrollId) {
		this.enrollId = enrollId;
	}

	public LocalDateTime getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(LocalDateTime enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Enrollment [enrollId=" + enrollId + ", enrollmentDate=" + enrollmentDate + ", status=" + status
				+ ", user=" + user + ", course=" + course + "]";
	}

}
