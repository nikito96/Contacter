package com.nikito.contacter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {
	
	@Autowired
	private ContactRepository contactRepository;
	
	@GetMapping("/addContact")
	public String addContact(Model model) {
		model.addAttribute("contact", new Contact());
		return "addContact";
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute Contact contact) {
		contactRepository.save(contact);
		return "addContact";
	}
}
