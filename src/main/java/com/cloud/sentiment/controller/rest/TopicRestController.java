package com.cloud.sentiment.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.sentiment.model.Topic;
import com.cloud.sentiment.service.TopicService;

@RestController
@RequestMapping("/api/v1/topic")
public class TopicRestController {

	@Autowired
	TopicService topicService;

	@GetMapping
	public ResponseEntity<List<Topic>> getAllTopics() {
		List<Topic> topics = topicService.getTopics();
		return new ResponseEntity<>(topics, HttpStatus.OK);
	}

	@GetMapping({ "/{topicId}" })
	public ResponseEntity<Topic> getTopic(@PathVariable Long topicId) {
		return new ResponseEntity<>(topicService.getTopicById(topicId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Topic> saveTopic(@RequestBody Topic topic) {
		Topic topic1 = topicService.insert(topic);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("todo", "/api/v1/todo/" + topic1.getId());

		return new ResponseEntity<>(topic1, httpHeaders, HttpStatus.CREATED);
	}

	@PutMapping({ "/{topicId}" })
	public ResponseEntity<Topic> updateTopic(@PathVariable("topicId") Long topicId, @RequestBody Topic topic) {
		topicService.updateTopic(topicId, topic);

		return new ResponseEntity<>(topicService.getTopicById(topicId), HttpStatus.OK);
	}

	@DeleteMapping({ "/{topicId}" })
	public ResponseEntity<Topic> deleteTopic(@PathVariable("topicId") Long topicId) {
		topicService.deleteTopic(topicId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
