package com.example.i18nsample.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	@PostMapping("login")
	public String login (Model model) {
		
		
		return "international";
		
		
	}
	
	
	
}
