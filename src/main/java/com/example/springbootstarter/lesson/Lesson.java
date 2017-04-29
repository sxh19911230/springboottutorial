package com.example.springbootstarter.lesson;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.springbootstarter.course.Course;

@Entity
public class Lesson {
	@Id
	private String id;
	private String description;
	@ManyToOne
	private Course course;
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Lesson() {}
	
	public Lesson(String id, String description, String courseId) {
		super();
		this.id = id;
		this.description = description;
		this.course = new Course(courseId, "", "", "");
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
