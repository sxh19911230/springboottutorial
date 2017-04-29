package com.example.springbootstarter.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getTopics() {
		List<Topic> topics = new ArrayList<Topic>();
		topicRepository.findAll().forEach(t->topics.add(t));
		return topics;
	}
	public Topic getTopic(String id) {
		Topic topic = topicRepository.findOne(id);
		return topic;
	}
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}
	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
		
	}
	public void deleteTopic(String id) {
		topicRepository.delete(id);
	}
	
}
