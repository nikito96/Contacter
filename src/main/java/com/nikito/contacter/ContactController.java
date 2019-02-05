package com.nikito.contacter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {
	
	@Autowired
	private ContactRepository contactRepository;
	
	@GetMapping("/addContact")
	public String addContact() {
		return "addContact";
	}
	
	@GetMapping("/add")
	public String add(@RequestParam(name="name") String name, 
			@RequestParam(name="number") String number, 
			@RequestParam(name="address") String address) {
		Contact c = new Contact();
		c.setName(name);
		c.setNumber(number);
		c.setAddress(address);
		contactRepository.save(c);
		return "addContact";
	}
}
