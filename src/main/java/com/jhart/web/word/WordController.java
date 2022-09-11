package com.jhart.web.word;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.jhart.dto.WordSupportDto;


@Controller
public class WordController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping({"/word/index"})
	public String index(Model model) {
		WordSupportDto wordSupportDto = new WordSupportDto();
		model.addAttribute("wordSupportDto", wordSupportDto);
		log.info("WordController - index");
		return "word/index";
	}

	@GetMapping({"/word/get"})
	public String get(Model model, String wordName, String inChar1, String inChar2, 
			String inChar3, String inChar4, String inChar5,
			String notInChar1, String notInChar2, String notInChar3, 
			String notInChar4, String notInChar5) {
		log.info("WordController - get - start");
		WordSupportDto wordSupportDto = new WordSupportDto();
		wordSupportDto.setWordName(wordName);
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
			executeWordSearch(wordSupportDto);
		}
		
		model.addAttribute("wordSupportDto", wordSupportDto);
		log.info("WordController - get - complete");
		return "word/index";
	}
	
	private void executeWordSearch(WordSupportDto wordSupportDto) {
		log.info("calling WordController executeWordSearch - ");
		// call service to generate words for WordSupportDto words. 
	}
	
	private boolean process(WordSupportDto wordSupportDto) {
		log.info("calling WordController process - ");
		
		if (!wordSupportDto.getWordName().isEmpty()) {
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
		
		return false;
	}
	
}
