package com.example.springbootstarter.lesson;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
	@Autowired
	private LessonRepository topicRepository;
	public List<Lesson> getLessons(String CourseId) {
		List<Lesson> lessons = new ArrayList<Lesson>();
		topicRepository.findByCourseId(CourseId).forEach(t->lessons.add(t));
		return lessons;
	}
	public Lesson getLesson(String id) {
		Lesson lesson = topicRepository.findOne(id);
		return lesson;
	}
	public void addLesson(Lesson lesson) {
		topicRepository.save(lesson);
	}
	public void updateLesson(Lesson lesson) {
		topicRepository.save(lesson);
		
	}
	public void deleteLesson(String id) {
		topicRepository.delete(id);
	}
	
}
