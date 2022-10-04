package com.jhart.web.word;

import java.util.Map;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhart.dto.WordSupportDto;
import com.jhart.service.word.WordService;

@Controller
@RequestMapping({"", "/", "/word"})
public class WordController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final WordService wordService;
	
	public WordController(WordService wordService) {
		this.wordService = wordService;
	}
	
	@GetMapping({"/index"})
	public String index(Model model) {
		log.info("WordController = index");
		WordSupportDto wordSupportDto = new WordSupportDto();
		model.addAttribute("wordSupportDto", wordSupportDto);
		log.info("WordController - index");
		return "word/index";
	}

	@GetMapping({"/get"})
	public String get(Model model, String wordName, String noWordName,
			String inChar1, String inChar2, 
			String inChar3, String inChar4, String inChar5) {
		log.info("WordController - get - start");
		
		wordName = wordName.toLowerCase();
		noWordName = noWordName.toLowerCase();
		inChar1 = inChar1.toLowerCase();
		inChar2 = inChar2.toLowerCase();
		inChar3 = inChar3.toLowerCase();
		inChar4 = inChar4.toLowerCase();
		
		WordSupportDto wordSupportDto = new WordSupportDto();
		
		if(null != wordName) {
			wordName = wordName.replace(",", "");
		}
		
		wordSupportDto.setWordName(wordName);
		
		if (null != noWordName) {
			noWordName = noWordName.replace(",", "");
		}
		
		wordSupportDto.setNoWordName(noWordName);
		wordSupportDto.setInChar1(inChar1);
		wordSupportDto.setInChar2(inChar2);
		wordSupportDto.setInChar3(inChar3);
		wordSupportDto.setInChar4(inChar4);
		wordSupportDto.setInChar5(inChar5);
		
		if (process(wordSupportDto)) {
			Map<String, String> response = executeWordSearch(wordSupportDto);
			wordSupportDto.setWords(response.get("wordNames"));
			wordSupportDto.setWordCount(response.get("wordCount"));
		}
		
		model.addAttribute("wordSupportDto", wordSupportDto);
		log.info("WordController - get - complete");
		return "word/index";
	}
	
	private Map<String, String> executeWordSearch(WordSupportDto wordSupportDto) {
		log.info("WordController executeWordSearch - ");
		Map<String, String> response = wordService.process(wordSupportDto);
		return response;
	}
	
	private boolean process(WordSupportDto wordSupportDto) {
		log.info("WordController process - ");
		
		
		if (null != wordSupportDto.getWordName() && 
				wordSupportDto.getWordName().length() > 0 &&
				wordSupportDto.getWordName().length() < 6) {
			return true;
		} 
		
		if (null != wordSupportDto.getNoWordName() && 
				wordSupportDto.getNoWordName().length() > 0 &&
				wordSupportDto.getNoWordName().length() < 22) {
			return true;
		}
		
		if (!wordSupportDto.getInChar1().isEmpty()) {
			return true;
		}
		if (!wordSupportDto.getInChar2().isEmpty()) {
			return true;
		}
		if (!wordSupportDto.getInChar3().isEmpty()) {
			return true;
		}
		if (!wordSupportDto.getInChar4().isEmpty()) {
			return true;
		}
		if (!wordSupportDto.getInChar5().isEmpty()) {
			return true;
		}
		
		log.info("WordController - process - invalid value submission");
		return false;
	}
	
}
