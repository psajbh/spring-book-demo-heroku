package com.jhart.service.word;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jhart.domain.Word;
import com.jhart.dto.WordSupportDto;
import com.jhart.repo.words.WordRepository;

@Service
public class WordServiceImpl implements WordService {
	
	private WordRepository wordRepository;
	
	public WordServiceImpl(WordRepository wordRepository) {
		this.wordRepository = wordRepository;
	}
	
	@Override
	public List<String> process(WordSupportDto wordSupportDto){
		List<Word> wordHolder = new ArrayList<>();
		List<String> wordNames = new ArrayList<>();
		List<Word> allWords = wordRepository.findAll();
		
		for(int i = 0; i < allWords.size(); i++) {
			Word word = allWords.get(i);
			if ("1" == word.getCommon()) {
				wordHolder.add(word);
			}
		}
		
		String wordName = wordSupportDto.getWordName();
		//char[] wordNameChars = wordName.toCharArray();
		
		for (int i = 0; i < wordHolder.size(); i++) {
			Word word = wordHolder.get(i);
			String wordText = word.getWord();
			char[] chars = wordText.toCharArray();
			String s;
			for (char ch: chars) {
				s = Character.toString(ch);
				if (wordName.contains(s)) {
					wordNames.add(wordName);
				}
				
			}
		}

		
		//List<Word> processedWords = new ArrayList<>();
		//use wordSupportDto to cull all words.
		//Word word = allWords.get(0);
		//word.getWord();
		//processedWords.add(word + ", ");
		return wordNames;
	}
	
}
