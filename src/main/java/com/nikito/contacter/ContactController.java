package com.nikito.contacter;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public String add(@ModelAttribute @Valid Contact contact, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "addContact";
		}
		contactRepository.save(contact);
		return "addContact";
	}
}
