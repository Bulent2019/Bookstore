package com.example.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
	@GetMapping("/index")
	public String friendIndex(@RequestParam(name = "", required = false) String name, Model model) {
		
//		Friend friend = new Friend();
//		model.addAttribute("friend", friend);
		return "index";
	}
}
