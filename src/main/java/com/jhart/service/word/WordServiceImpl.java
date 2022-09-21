package com.jhart.service.word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jhart.domain.Word;
import com.jhart.dto.WordSupportDto;
import com.jhart.repo.words.WordRepository;

@Service
public class WordServiceImpl implements WordService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final WordRepository wordRepository;
	private List<Word> allWords;
	private List<Word> wordHolder; 
	private Map<String, String> response;
	
	public WordServiceImpl(WordRepository wordRepository) {
		this.wordRepository = wordRepository;
	}

	@Override
	public Map<String, String> process(WordSupportDto wordSupportDto) {
		//List<Word> wordHolder = new ArrayList<>();
		//List<String> wordNames = new ArrayList<>();
		List<Word> originalWords = new ArrayList<>();
		//List<String> cleanWordNames = new ArrayList<>();
		
		if (null == allWords) {
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
		
			log.info("wordHolder size: " + wordHolder.size());
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
		
		// setup noWordNames
		//   reset all original words 
		String noWordName = wordSupportDto.getNoWordName();
		 
		for (int i = 0; i < originalWords.size(); i++) { 
			Word word =  originalWords.get(i);
			word.setUnavailable(false);
			String wordText = word.getWord();
			//log.info("wordText: " + wordText);
			
			char[] chars = wordText.toCharArray();
			String s;
			for (char ch : chars) {
				s = Character.toString(ch);
				if (noWordName.contains(s)) {
					//log.debug("removing " + noWordName.toString() + " from originalWords for char "+ s);
					//originalWords.remove(word);
					word.setUnavailable(true);
					break;
				}
			}
		}
		
		//log.info("originalWords refactored to size: " + originalWords.size());
		
		StringBuilder sb = new StringBuilder();
		//String response = null;
		Integer wordCount = 0;
		for (int i = 0; i < originalWords.size(); i++) {
			Word w = originalWords.get(i);
			if (w.isUnavailable()) {
				//log.info(w.getWord() + " is not processed do to unavailabilty");
				continue;
			}
			else {
				//String strWord = w.getWord();
				sb.append(w.getWord() + ", ");
				wordCount++;
			}
		}
		//log.info("originalWords refactored to size: " + originalWords.size());
		Map<String, String> response = new HashMap<>();
		response.put("wordNames", sb.toString());
		response.put("wordCount", wordCount.toString());
		
		//String returnValue = sb.toString() + "|" + wordCount; 
		log.info("returnValue: " + response);
		return response;
	}

}
