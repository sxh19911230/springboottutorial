package com.example.springbootstarter.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	@Autowired
	private CourseRepository topicRepository;
	public List<Course> getCourses(String topicId) {
		List<Course> courses = new ArrayList<Course>();
		topicRepository.findByTopicId(topicId).forEach(t->courses.add(t));
		return courses;
	}
	public Course getCourse(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		Course course = topicRepository.findOne(id);
		return course;
	}
	public void addCourse(Course course) {
		//topics.add(topic);
		topicRepository.save(course);
	}
	public void updateCourse(Course course) {
		topicRepository.save(course);
		
	}
	public void deleteCourse(String id) {
		topicRepository.delete(id);
	}
	
}
