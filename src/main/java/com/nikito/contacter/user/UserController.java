package com.nikito.contacter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

	@Autowired
	UserRepository repository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "/register";
	}
	
	@PostMapping("/register")
	public String reg(@ModelAttribute User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		repository.save(user);
		return "/login";
	}
}
