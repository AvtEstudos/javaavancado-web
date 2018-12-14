package br.com.allianz.boot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index(Model model) {
		
		model.addAttribute("mensagem", "Projeto Spring Boot");
		return "index";
		
	}

}
