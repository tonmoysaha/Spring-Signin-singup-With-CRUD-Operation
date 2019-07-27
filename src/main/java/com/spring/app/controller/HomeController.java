package com.spring.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping("/parents")
	public String showParentPage() {
		return "parent";
	}
	
	@GetMapping("/childrens")
	public String showSonPage() {
		return "childrens";
	}
	
}
