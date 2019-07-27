package com.spring.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class LoginPageController {
	@GetMapping("/mylogin")
	public String shoLoginPage() {
		return "fancy-login";
	}
}
