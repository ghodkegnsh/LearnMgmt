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

	public Course() {
		super();

	}

	public Course(int courseId, String courseName, int courseDuration, LocalDateTime startDate, LocalDateTime endDate,
			Category category, Set<Enrollment> enrollment) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
		this.startDate = startDate;
		this.endDate = endDate;
		this.category = category;
		this.enrollment = enrollment;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Enrollment> getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(Set<Enrollment> enrollment) {
		this.enrollment = enrollment;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseDuration=" + courseDuration
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", category=" + category + ", enrollment="
				+ enrollment + "]";
	}

}
