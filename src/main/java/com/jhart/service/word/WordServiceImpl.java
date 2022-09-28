package com.jhart.service.word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import com.jhart.domain.Word;
import com.jhart.dto.WordSupportDto;
import com.jhart.repo.words.WordRepository;

@Service
public class WordServiceImpl implements WordService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final WordRepository wordRepository;
	
	private List<Word> allWords;
	private List<Word> wordHolder; 
	//private Map<String, String> response;
	
	public WordServiceImpl(WordRepository wordRepository) {
		this.wordRepository = wordRepository;
	}

	@Override
	public Map<String, String> process(WordSupportDto wordSupportDto) {
		log.info("WordServiceImpl process start");
		List<Word> originalWords = setOriginalWords(wordSupportDto);
		if (!wordSupportDto.getInChar1().isEmpty()) {
			log.info("InChar1: " + wordSupportDto.getInChar1());
		}
		
		List<Word> availablewords = processUnavailable(wordSupportDto.getNoWordName(), originalWords); 
		
		if (null != availablewords && availablewords.size() > 0) {
			availablewords = processChar1Unavailable(wordSupportDto, availablewords);
			availablewords = processChar2Unavailable(wordSupportDto, availablewords);
			availablewords = processChar3Unavailable(wordSupportDto, availablewords);
			availablewords = processChar4Unavailable(wordSupportDto, availablewords);
			availablewords = processChar5Unavailable(wordSupportDto, availablewords);
		}
		
		StringBuilder sb = new StringBuilder();
		Integer wordCount = 0;
	
		for (int i = 0; i < availablewords.size(); i++) {
			Word w = availablewords.get(i);
			if (w.isUnavailable()) {
				continue;
			}
			else {
				sb.append(w.getWord() + ", ");
				wordCount++;				
			}
		}
		
		String wordNames = "";
		if (sb.toString().length() > 6) {
			wordNames = StringUtils.substring(sb.toString(),0, sb.toString().length()-2);
		}

		Map<String, String> response = new HashMap<>();
		response.put("wordNames", wordNames);
		response.put("wordCount", wordCount.toString());
		log.info("returnValue: " + response);
		return response;
	}
	
	private List<Word> processChar1Unavailable(WordSupportDto wordSupportDto, List<Word> availablewords) {
		if(!wordSupportDto.getInChar1().isEmpty()) {
			for (int i = 0; i < availablewords.size(); i++) { 
				Word w =  availablewords.get(i);
				if (!w.isUnavailable()) {
					if(w.getChar1().equals(wordSupportDto.getInChar1())){
						w.setUnavailable(false);
					}
					else {
						w.setUnavailable(true);
					}
					continue;
				}
			}
		}
		return availablewords;
	}
	
	private List<Word> processChar2Unavailable(WordSupportDto wordSupportDto, List<Word> availablewords) {
		if(!wordSupportDto.getInChar2().isEmpty()) {
			for (int i = 0; i < availablewords.size(); i++) { 
				Word w =  availablewords.get(i);
				if (!w.isUnavailable()) {
					if(w.getChar2().equals(wordSupportDto.getInChar2())){
						w.setUnavailable(false);
					}
					else {
						w.setUnavailable(true);
					}
					continue;
				}			
			}
		}
		return availablewords;
	}


	private List<Word> processChar3Unavailable(WordSupportDto wordSupportDto, List<Word> availablewords) {
		if(!wordSupportDto.getInChar3().isEmpty()) {
			for (int i = 0; i < availablewords.size(); i++) { 
				Word w =  availablewords.get(i);
				if (!w.isUnavailable()) {
					if(w.getChar3().equals(wordSupportDto.getInChar3())){
						w.setUnavailable(false);
					}
					else {
						w.setUnavailable(true);
					}
					continue;
				}			
			}
		}
		return availablewords;
	}

	private List<Word> processChar4Unavailable(WordSupportDto wordSupportDto, List<Word> availablewords) {
		if(!wordSupportDto.getInChar4().isEmpty()) {
			for (int i = 0; i < availablewords.size(); i++) { 
				Word w =  availablewords.get(i);
				if (!w.isUnavailable()) {
					if(w.getChar4().equals(wordSupportDto.getInChar4())){
						w.setUnavailable(false);
					}
					else {
						w.setUnavailable(true);
					}
					continue;
				}			

			}
		}
		return availablewords;
	}
	
	private List<Word> processChar5Unavailable(WordSupportDto wordSupportDto, List<Word> availablewords) {
		if(!wordSupportDto.getInChar5().isEmpty()) {
			for (int i = 0; i < availablewords.size(); i++) { 
				Word w =  availablewords.get(i);
				if (!w.isUnavailable()) {
					if(w.getChar5().equals(wordSupportDto.getInChar5())){
						w.setUnavailable(false);
					}
					else {
						w.setUnavailable(true);
					}
					continue;
				}			

			}
		}
		return availablewords;
	}
	
	private List<Word> processUnavailable(String unavailableChars, List<Word> originalWords) {
		
		for (int i = 0; i < originalWords.size(); i++) { 
			Word word =  originalWords.get(i);
			//reset word unavailability to false
			word.setUnavailable(false);
			String wordText = word.getWord();
			
			char[] chars = wordText.toCharArray();
			String s;
			for (char ch : chars) {
				s = Character.toString(ch);
				if (unavailableChars.contains(s)) {
					//reset unavailability to true
					word.setUnavailable(true);
					break;
				}
			}
		}

		return originalWords;
	}
	
	private List<Word> setOriginalWords(WordSupportDto wordSupportDto) {
		log.info("setOriginalWords - start");
		List<Word> originalWords = new ArrayList<>();
		if (null == allWords) {
			log.info("setOriginalWords - calling findAll");
			long start = System.currentTimeMillis();
			allWords = wordRepository.findAll();
			int size = allWords.size();
			if (null != wordHolder) {
				wordHolder.clear();
			}
			else {
				wordHolder = new ArrayList<Word>();
			}
		
			for (int i = 0; i < size; i++) {
				Word word = allWords.get(i);
				if (word.getCommon().equals("1")) {
					wordHolder.add(word);
					// log.debug("*** added word " + name.toString() + " - " + common + " to baseline");
				}
			}
		
			long finish = System.currentTimeMillis();
			log.info("wordHolder size: " + wordHolder.size() + " elapsed time: " + (finish - start)/1000 + " seconds");
		}	 

		// now we have a list of words to process.
		// setup wordNames
		String wordName = wordSupportDto.getWordName();
		// char[] wordNameChars = wordName.toCharArray();

		// process words part 1 add all alpha names
		for (int i = 0; i < wordHolder.size(); i++) {
			Word word = wordHolder.get(i);
			String wordText = word.getWord();
			//log.info("wordText: " + wordText);

			char[] chars = wordText.toCharArray();
			String s;
			for (char ch : chars) {
				s = Character.toString(ch);
				if (wordName.contains(s)) {
					//log.debug("adding " + word.toString() + " to wordNames for char " + s);
					originalWords.add(word);
					break;
				}
			}
		}
		
		log.info("originalWords size: " + originalWords.size());

		return originalWords;
	}

}
