package com.cloud.sentiment.controller.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cloud.sentiment.constant.TopicStatus;
import com.cloud.sentiment.model.Topic;
import com.cloud.sentiment.service.TopicService;

@Controller
public class TopicController {

	@Autowired
	private TopicService topicService;

	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}

	@GetMapping("/add-topic")
	public String addTopic(Model model) {
		model.addAttribute("topic", new Topic());
		return "add-topic";
	}

	@PostMapping("/create-topic")
	public String postTopic(Topic topic, BindingResult result, Model model) {
		topic.setStatus(TopicStatus.STATUS_IN_PROGRESS);
		topicService.insert(topic);
		return "redirect:/view-topic";
	}

	@GetMapping("/view-topic")
	public String viewTopic(Model model) {
		List<Topic> topicList = topicService.getTopics();
		model.addAttribute("topicList", topicList);

		return "view-topic";
	}

	@GetMapping("/word-cloud")
	public String viewWordCloud(Model model) {
		return "word-cloud";
	}

}
