package com.jhart.web.games.word;

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
@RequestMapping({"", "/", "/games/word"})
public class WordController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final WordService wordService;
	
	public WordController(WordService wordService) {
		this.wordService = wordService;
	}
	
	@GetMapping({"/index"})
	public String index(Model model) {
		WordSupportDto wordSupportDto = new WordSupportDto();
		model.addAttribute("wordSupportDto", wordSupportDto);
		return "games/word/index";
	}

	@GetMapping({"/get"})
	public String get(Model model, String wordName, String noWordName,
			String inChar1, String inChar2, 
			String inChar3, String inChar4, String inChar5,
			String notInChar1, String notInChar2, String notInChar3,
			String notInChar4, String notInChar5) {
		log.info("WordController - get -> start");
		
		wordName = wordName.toLowerCase();
		noWordName = noWordName.toLowerCase();
		inChar1 = inChar1.toLowerCase();
		inChar2 = inChar2.toLowerCase();
		inChar3 = inChar3.toLowerCase();
		inChar4 = inChar4.toLowerCase();
		inChar5 = inChar5.toLowerCase();
		notInChar1 = notInChar1.toLowerCase();
		notInChar2 = notInChar2.toLowerCase();
		notInChar3 = notInChar3.toLowerCase();
		notInChar4 = notInChar4.toLowerCase();
		notInChar5 = notInChar5.toLowerCase();
		
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
			String wordCount = response.get("wordCount");
			String charAnalysis1 = response.get("charAnalysis1");
			String charAnalysis2 = response.get("charAnalysis2");
			String charAnalysis3 = response.get("charAnalysis3");
			String charAnalysis4 = response.get("charAnalysis4");
			String charAnalysis5 = response.get("charAnalysis5");
			
			
			
			int i = Integer.parseInt(wordCount);
			if (i > 400) {
				String[] wordArray = response.get("wordNames").split(",");
				
				StringBuilder builder = new StringBuilder();
				int j = 0;
				for(String str : wordArray) {
					builder.append(str + ", ");
					j++;
					if(j > 400) {
						break;
					}
				}
				
				String displayWords = builder.toString();
				displayWords = displayWords.substring(0, displayWords.length()-2) + " ...";
				
				String note = "Cannot display more than 400 words "
						+ "at a time. The display will show a subset "
						+ "of associated words that include the following: "
						+ displayWords;
				
				wordSupportDto.setWords(note);
			}
			else {
				wordSupportDto.setWords(response.get("wordNames"));
			}
			wordSupportDto.setWordCount(wordCount);
			wordSupportDto.setWordAnalysis_1(charAnalysis1);
			wordSupportDto.setWordAnalysis_2(charAnalysis2);
			wordSupportDto.setWordAnalysis_3(charAnalysis3);
			wordSupportDto.setWordAnalysis_4(charAnalysis4);
			wordSupportDto.setWordAnalysis_5(charAnalysis5);
		}
		
		model.addAttribute("wordSupportDto", wordSupportDto);
		log.info("WordController - get -> complete");
		return "games/word/index";
	}
	
	private Map<String, String> executeWordSearch(WordSupportDto wordSupportDto) {
		Map<String, String> response = wordService.process(wordSupportDto);
		log.trace("WordController executeWordSearch -> response: " + response);
		return response;
	}
	
	private boolean process(WordSupportDto wordSupportDto) {
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
