package com.jhart.web.word;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jhart.domain.Word;
import com.jhart.dto.WordSupportDto;
import com.jhart.service.word.WordService;


@Controller
public class WordController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final WordService wordService;
	
	
	public WordController(WordService wordService) {
		this.wordService = wordService;
	}
	
	@GetMapping({"/word/index"})
	public String index(Model model) {
		WordSupportDto wordSupportDto = new WordSupportDto();
		model.addAttribute("wordSupportDto", wordSupportDto);
		log.info("WordController - index");
		return "word/index";
	}

	@GetMapping({"/word/get"})
	public String get(Model model, String wordName, String noWordName,
			String inChar1, String inChar2, 
			String inChar3, String inChar4, String inChar5,
			String notInChar1, String notInChar2, String notInChar3, 
			String notInChar4, String notInChar5) {
		log.info("WordController - get - start");
		
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
		wordSupportDto.setNotInChar1(notInChar1);
		wordSupportDto.setNotInChar2(notInChar2);
		wordSupportDto.setNotInChar3(notInChar3);
		wordSupportDto.setNotInChar4(notInChar4);
		wordSupportDto.setNotInChar5(notInChar5);
		
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
		//List<String> words = wordService.process(wordSupportDto);
		Map<String, String> response = wordService.process(wordSupportDto);
		
		//String values = wordService.process(wordSupportDto);
		//log.info("WordController process result: " + values);
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
		
		if (!wordSupportDto.getNotInChar1().isEmpty()) {
			return true;
		}
		if (!wordSupportDto.getNotInChar2().isEmpty()) {
			return true;
		}
		if (!wordSupportDto.getNotInChar3().isEmpty()) {
			return true;
		}
		if (!wordSupportDto.getNotInChar4().isEmpty()) {
			return true;
		}
		if (!wordSupportDto.getNotInChar5().isEmpty()) {
			return true;
		}
		
		log.info("WordController - process - invalid value submission");
		return false;
	}
	
}
