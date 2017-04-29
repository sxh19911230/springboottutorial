package com.example.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	@Autowired
	private TopicRepository topicRepository;
	private List<Topic> topics = new ArrayList<Topic> (Arrays.asList(
			new Topic("spring","Spring Framework","Srping Framework Description"),
			new Topic("java","Core JAVA","Core JAVA Description")
			));
	
	public List<Topic> getTopics() {
		//return topics;
		List<Topic> topics = new ArrayList<Topic>();
		topicRepository.findAll().forEach(t->topics.add(t));
		return topics;
	}
	public Topic getTopic(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		Topic topic = topicRepository.findOne(id);
		return topic;
	}
	public void addTopic(Topic topic) {
		//topics.add(topic);
		topicRepository.save(topic);
	}
	public void updateTopc(String id, Topic topic) {
		topicRepository.delete(id);
		topicRepository.save(topic);
		
	}
	public void deleteTopic(String id) {
		topicRepository.delete(id);
	}
	
}
