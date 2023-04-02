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
import com.jhart.util.word.CharDisplay;
import com.jhart.util.word.CharDisplayBuilder;
import com.jhart.util.word.Evaluator;

@Service
public class WordServiceImpl implements WordService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final WordRepository wordRepository;
	private final CharDisplayBuilder charDisplayBuilder;

	private List<Word> allWords;
	private List<Word> wordHolder;
	private Map<Integer, ArrayList<CharDisplay>> charDisplayMap = new HashMap<>();

	public WordServiceImpl(WordRepository wordRepository, CharDisplayBuilder charDisplayBuilder) {
		this.wordRepository = wordRepository;
		this.charDisplayBuilder = charDisplayBuilder;
	}

	@Override
	public Map<String, String> process(WordSupportDto wordSupportDto) {
		log.info("WordServiceImpl process start");
		List<Word> originalWords = setOriginalWords(wordSupportDto);

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
			} else {
				sb.append(w.getWord() + ", ");
				wordCount++;
			}
		}

		String wordNames = "";
		if (sb.toString().length() > 6) {
			wordNames = StringUtils.substring(sb.toString(), 0, sb.toString().length() - 2);
		}

		Map<String, String> response = new HashMap<>();
		response.put("wordNames", wordNames);
		response.put("wordCount", wordCount.toString());
		
		Map<Integer, ArrayList<CharDisplay>> charDisplayAnalysis = 
				wordNamesAnalysis(wordNames, wordCount);
		String charAnalysis = charDisplayBuilder.buildCharDisplay(charDisplayAnalysis);
		response.put("wordAnalysis", charAnalysis);
		
		log.trace("returnValue: " + response);
		return response;
	}
	
	private Map<Integer, ArrayList<CharDisplay>> wordNamesAnalysis(String words, Integer wordCount) {
		System.out.println("executing wordNames Analysis");
		List<CharDisplay> level1CharDisplay = new ArrayList<>();
		List<CharDisplay> level2CharDisplay = new ArrayList<>();
		List<CharDisplay> level3CharDisplay = new ArrayList<>();
		List<CharDisplay> level4CharDisplay = new ArrayList<>();
		List<CharDisplay> level5CharDisplay = new ArrayList<>();

		String[] wordArray = words.split(", ");
		Evaluator evaluator = new Evaluator();
		evaluator.evaluate(wordArray);
		
		Map<String, Integer> wordMap = evaluator.getWordAnalysis();
		
		for(Map.Entry<String, Integer> entry : wordMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
			CharDisplay cd = new CharDisplay(entry.getKey());
			cd.setValue(entry.getValue().toString());
			
			if (cd.getLevel().equals("1")) {
				level1CharDisplay.add(cd);
			}
			if (cd.getLevel().equals("2")) {
				level2CharDisplay.add(cd);
			}
			if (cd.getLevel().equals("3")) {
				level3CharDisplay.add(cd);
			}
			if (cd.getLevel().equals("4")) {
				level4CharDisplay.add(cd);
			}
			if (cd.getLevel().equals("5")) {
				level5CharDisplay.add(cd);
			}
		}
		
		if (level1CharDisplay.size() > 0
			&& level2CharDisplay.size() > 0
			&& level3CharDisplay.size() > 0
			&& level4CharDisplay.size() > 0
			&& level5CharDisplay.size() > 0) {
			charDisplayMap.put(1, (ArrayList<CharDisplay>)level1CharDisplay);
			
			charDisplayMap.put(2, (ArrayList<CharDisplay>)level2CharDisplay);
			charDisplayMap.put(3, (ArrayList<CharDisplay>)level3CharDisplay);
			charDisplayMap.put(4, (ArrayList<CharDisplay>)level4CharDisplay);
			charDisplayMap.put(5, (ArrayList<CharDisplay>)level5CharDisplay);
			return charDisplayMap;
		}
		else {
			return null;
		}
	}

	private List<Word> processChar1Unavailable(WordSupportDto wordSupportDto, List<Word> availablewords) {
		if (!wordSupportDto.getInChar1().isEmpty()) {
			log.debug("processing inChar1 - " + wordSupportDto.getInChar1());
			for (int i = 0; i < availablewords.size(); i++) {
				Word w = availablewords.get(i);
				if (!w.isUnavailable()) {
					if (w.getChar1().equals(wordSupportDto.getInChar1())) {
						w.setUnavailable(false);
					} else {
						w.setUnavailable(true);
					}
					continue;
				}
			}
		} 
		else {
			log.debug("processing for notInChar1 - values");
			if (!wordSupportDto.getNotInChar1().isEmpty()) {
				for (int i = 0; i < availablewords.size(); i++) {
					Word w = availablewords.get(i);
					if (!w.isUnavailable()) {
						if (1 == wordSupportDto.getNotInChar1().length()) {
							if (w.getChar1().equals(wordSupportDto.getNotInChar1())) {
								log.debug("char1 value of '" + w.getChar1() + "' sets the word: " + w.getWord()
										+ " as unavailable");
								w.setUnavailable(true);
							}
						}
						else {
							int n = 1;
							String[] results = wordSupportDto.getNotInChar1().split("(?<=\\G.{" + n + "})");
							for (String s: results) { 
								
							   if (w.getChar1().contains(s)){
								   log.debug("setting word: " + w + " as NOT available as it matches the character " + s);
								   w.setUnavailable(true);
								   break;
							   }
							}
						}
					}
					continue;
				}
			}
		}
		return availablewords;
	}

	private List<Word> processChar2Unavailable(WordSupportDto wordSupportDto, List<Word> availablewords) {
		if (!wordSupportDto.getInChar2().isEmpty()) {
			for (int i = 0; i < availablewords.size(); i++) {
				Word w = availablewords.get(i);
				if (!w.isUnavailable()) {
					if (w.getChar2().equals(wordSupportDto.getInChar2())) {
						w.setUnavailable(false);
					} else {
						w.setUnavailable(true);
					}
					continue;
				}
			}
		} 
		else {
			log.debug("processing for notInChar2 - values");
			if (!wordSupportDto.getNotInChar2().isEmpty()) {
				for (int i = 0; i < availablewords.size(); i++) {
					Word w = availablewords.get(i);
					if (!w.isUnavailable()) {
						if (1 == wordSupportDto.getNotInChar2().length()) {
							if (w.getChar2().equals(wordSupportDto.getNotInChar2())) {
								log.debug("char2 value of '" + w.getChar2() + "' sets the word: " + w.getWord()
										+ " as unavailable");
								w.setUnavailable(true);
							}
						}
						else {
							int n = 1;
							String[] results = wordSupportDto.getNotInChar2().split("(?<=\\G.{" + n + "})");
							for (String s: results) { 
							   if (w.getChar2().contains(s)){
								   log.debug("setting word: " + w + " as NOT available as it matches the character " + s);
								   w.setUnavailable(true);
								   break;
							   }
							}
						}
					}
					continue;
				}
			}
		}
		return availablewords;
	}

	private List<Word> processChar3Unavailable(WordSupportDto wordSupportDto, List<Word> availablewords) {
		if (!wordSupportDto.getInChar3().isEmpty()) {
			for (int i = 0; i < availablewords.size(); i++) {
				Word w = availablewords.get(i);
				if (!w.isUnavailable()) {
					if (w.getChar3().equals(wordSupportDto.getInChar3())) {
						w.setUnavailable(false);
					} else {
						w.setUnavailable(true);
					}
					continue;
				}
			}
		} 
		else {
			log.debug("processing for notInChar3 - values");
			if (!wordSupportDto.getNotInChar3().isEmpty()) {
				for (int i = 0; i < availablewords.size(); i++) {
					Word w = availablewords.get(i);
					if (!w.isUnavailable()) {
						
						if (1 == wordSupportDto.getNotInChar3().length()) {
							if (w.getChar3().equals(wordSupportDto.getNotInChar3())) {
								log.debug("char3 value of '" + w.getChar3() + "' sets the word: " + w.getWord()
										+ " as unavailable");
								w.setUnavailable(true);
							}
						}
						else {
							int n = 1;
							String[] results = wordSupportDto.getNotInChar3().split("(?<=\\G.{" + n + "})");
							for (String s: results) { 
							   if (w.getChar3().contains(s)){
								   log.debug("setting word: " + w + " as NOT available as it matches the character " + s);
								   w.setUnavailable(true);
								   break;
							   }
							}
						}
					}
					continue;
				}
			}
		}
		return availablewords;
	}

	private List<Word> processChar4Unavailable(WordSupportDto wordSupportDto, List<Word> availablewords) {
		if (!wordSupportDto.getInChar4().isEmpty()) {
			for (int i = 0; i < availablewords.size(); i++) {
				Word w = availablewords.get(i);
				if (!w.isUnavailable()) {
					if (w.getChar4().equals(wordSupportDto.getInChar4())) {
						w.setUnavailable(false);
					} else {
						w.setUnavailable(true);
					}
					continue;
				}
			}
		} 
		else {
			log.debug("processing for notInChar4 - values");
			if (!wordSupportDto.getNotInChar4().isEmpty()) {
				for (int i = 0; i < availablewords.size(); i++) {
					Word w = availablewords.get(i);
					if (!w.isUnavailable()) {
						
						if (1 == wordSupportDto.getNotInChar4().length()) {
							if (w.getChar4().equals(wordSupportDto.getNotInChar4())) {
								log.debug("char4 value of '" + w.getChar4() + "' sets the word: " + w.getWord()
										+ " as unavailable");
								w.setUnavailable(true);
							}
						}
						else {
							int n = 1;
							String[] results = wordSupportDto.getNotInChar4().split("(?<=\\G.{" + n + "})");
							for (String s: results) { 
							   if (w.getChar4().contains(s)){
								   log.debug("setting word: " + w + " as NOT available as it matches the character " + s);
								   w.setUnavailable(true);
								   break;
							   }
							}
						}
					}
					continue;
				}
			}
		}
		return availablewords;
	}

	private List<Word> processChar5Unavailable(WordSupportDto wordSupportDto, List<Word> availablewords) {
		if (!wordSupportDto.getInChar5().isEmpty()) {
			for (int i = 0; i < availablewords.size(); i++) {
				Word w = availablewords.get(i);
				if (!w.isUnavailable()) {
					if (w.getChar5().equals(wordSupportDto.getInChar5())) {
						w.setUnavailable(false);
					} else {
						w.setUnavailable(true);
					}
					continue;
				}
			}
		} 
		else {
			log.debug("processing for notInChar5 - values");
			if (!wordSupportDto.getNotInChar5().isEmpty()) {
				for (int i = 0; i < availablewords.size(); i++) {
					Word w = availablewords.get(i);
					if (!w.isUnavailable()) {
						if (1 == wordSupportDto.getNotInChar5().length()) {
							if (w.getChar5().equals(wordSupportDto.getNotInChar5())) {
								log.debug("char5 value of '" + w.getChar5() + "' sets the word: " + w.getWord()
										+ " as unavailable");
								w.setUnavailable(true);
							}
						}
						else {
							int n = 1;
							String[] results = wordSupportDto.getNotInChar5().split("(?<=\\G.{" + n + "})");
							for (String s: results) { 
							   if (w.getChar5().contains(s)){
								   log.debug("setting word: " + w + " as NOT available as it matches the character " + s);
								   w.setUnavailable(true);
								   break;
							   }
							}
						}
					}
					continue;
				}
			}
		}
		return availablewords;
	}

	private List<Word> processUnavailable(String unavailableChars, List<Word> originalWords) {

		for (int i = 0; i < originalWords.size(); i++) {
			Word word = originalWords.get(i);
			word.setUnavailable(false);
			String wordText = word.getWord();

			char[] chars = wordText.toCharArray();
			String s;
			for (char ch : chars) {
				s = Character.toString(ch);
				if (unavailableChars.contains(s)) {
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
			} else {
				wordHolder = new ArrayList<Word>();
			}

			for (int i = 0; i < size; i++) {
				Word word = allWords.get(i);
				if (word.getCommon().equals("1")) {
					wordHolder.add(word);
				}
			}

			long finish = System.currentTimeMillis();
			log.info("wordHolder size: " + wordHolder.size() + " elapsed time: " + 
					(finish - start) / 1000 + " seconds");
		}

		String wordName = wordSupportDto.getWordName();

		for (int i = 0; i < wordHolder.size(); i++) {
			Word word = wordHolder.get(i);
			String wordText = word.getWord();

			String s;
			boolean match = false;

			char[] chars = wordName.toCharArray();
			for (char ch : chars) {
				s = Character.toString(ch);
				if (wordText.contains(s)) {
					match = true;
				} else {
					match = false;
					break;
				}
			}

			if (match) {
				originalWords.add(word);
			}
		}

		log.info("originalWords size: " + originalWords.size());
		return originalWords;
	}
	

}
