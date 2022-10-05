package com.stuhome;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class homeController {
	
	@GetMapping("/home")
	ModelAndView Home() {
		ModelAndView index = new ModelAndView();
		index.setViewName("index.html");
		return index;
	}
	
	
}
