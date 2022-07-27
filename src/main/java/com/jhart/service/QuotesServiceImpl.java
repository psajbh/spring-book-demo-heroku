package com.jhart.service;

import org.springframework.stereotype.Service;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;

@Service
public class QuotesServiceImpl implements QuotesService {
	
	private final ChuckNorrisQuotes chuckNorrisQuotes;
	
	public QuotesServiceImpl() {
		this.chuckNorrisQuotes = new ChuckNorrisQuotes();
	}
	
	public String getQuote() {
		return chuckNorrisQuotes.getRandomQuote();
	}
	

}
