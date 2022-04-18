package com.cloud.sentiment.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.sentiment.exception.TopicNotFoundException;
import com.cloud.sentiment.model.Topic;
import com.cloud.sentiment.repository.TopicRepository;
import com.cloud.sentiment.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	TopicRepository topicRepository;

	@Override
	public List<Topic> getTopics() {
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);

		return topics;
	}

	@Override
	public Topic getTopicById(Long id) throws TopicNotFoundException {
		Optional<Topic> topic = topicRepository.findById(id);

		if (topic.isEmpty()) {
			throw new TopicNotFoundException();
		}

		return topic.get();
	}

	@Override
	public Topic getTopicByTitle(String title) throws TopicNotFoundException {
		Optional<Topic> topic = topicRepository.findByTitle(title);

		if (topic.isEmpty()) {
			throw new TopicNotFoundException();
		}

		return topic.get();
	}

	@Override
	public Topic insert(Topic topic) {
		return topicRepository.save(topic);
	}

	@Override
	public void updateTopic(Long id, Topic topic) throws TopicNotFoundException {
		Optional<Topic> topicDb = topicRepository.findById(id);

		if (topicDb.isEmpty()) {
			throw new TopicNotFoundException();
		}

		Topic topic1 = topicDb.get();
		topic1.setTitle(topic.getTitle());
		topic1.setDescription(topic.getDescription());
	}

	@Override
	public void deleteTopic(Long topicId) throws TopicNotFoundException {
		topicRepository.deleteById(topicId);
	}
}
