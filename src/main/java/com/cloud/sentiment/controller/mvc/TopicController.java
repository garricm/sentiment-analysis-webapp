package com.cloud.sentiment.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TopicController {

	@RequestMapping("/")
	public String index(Model model) {
		return "index";
	}

	@RequestMapping("/add-topic")
	public String addTopic(Model model) {
		return "add-topic";
	}
	
	@RequestMapping("/view-topic")
	public String viewTopic(Model model) {
//		model.addAttribute("name", name);
		return "view-topic";
	}

}
