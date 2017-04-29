package com.example.springbootstarter.lesson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootstarter.course.Course;

@RestController
public class LessonController {
	
	@Autowired
	private LessonService lessonService;
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons")
	public List<Lesson> getCourses(@PathVariable String courseId) {
		return lessonService.getLessons(courseId);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/topics/{topicIid}/courses/{courseId}/lessons/{id}")
	public Lesson getCourse(@PathVariable String id) {
		return lessonService.getLesson(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses/{courseId}/lessons")
	public void addCourse(@RequestBody Lesson lesson, @PathVariable String courseId) {
		lesson.setCourse(new Course(courseId,"","",""));
		lessonService.addLesson(lesson);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public void updateCourse(@RequestBody Lesson lesson, @PathVariable String courseId) {
		lesson.setCourse(new Course(courseId, "", "", ""));
		lessonService.updateLesson(lesson);;
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{courseId}/lessons{id}")
	public void deleteCourse(@PathVariable String id) {
		lessonService.deleteLesson(id);
	}

}
