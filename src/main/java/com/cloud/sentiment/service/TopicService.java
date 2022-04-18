package com.cloud.sentiment.service;

import java.util.List;

import com.cloud.sentiment.exception.TopicAlreadyExistsException;
import com.cloud.sentiment.exception.TopicNotFoundException;
import com.cloud.sentiment.model.Topic;

public interface TopicService {

	List<Topic> getTopics();

	Topic getTopicById(Long id) throws TopicNotFoundException;

	Topic getTopicByTitle(String title) throws TopicNotFoundException;

	Topic insert(Topic topic) throws TopicAlreadyExistsException;

	void updateTopic(Long id, Topic topic) throws TopicNotFoundException;

	void deleteTopic(Long topicId) throws TopicNotFoundException;

}
