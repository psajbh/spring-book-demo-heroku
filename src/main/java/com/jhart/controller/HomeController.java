package com.jhart.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhart.service.QuotesService;

@Controller
public class HomeController {
	
	private QuotesService quotesService;
	
	@Autowired
	public HomeController(QuotesService quotesService) {
		this.quotesService = quotesService;
	}
	
	@GetMapping({"/",""})
	public String setup(Model model) {
		model.addAttribute("url", "/quote");
		model.addAttribute("quote", "");
		return "quote";
	}
	
	@GetMapping({"/quote"})
	public String getQuote(Model model) {
		String quote = quotesService.getQuote();
		model.addAttribute("url", "/quote");
		model.addAttribute("quote", quote);
		return "quote";
	}

}
