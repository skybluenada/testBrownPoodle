package com.brownpoodle.walk.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WalkController {
	Logger logger = Logger.getLogger(WalkController.class);
	
	
	@RequestMapping(value = "walkMain", method = RequestMethod.GET)
	public String walkMain() {
		logger.info("WalkController walkMain() >>> : ");
		return "walk/walk_main";
	}
	
	
	
	
	
	
	
}
