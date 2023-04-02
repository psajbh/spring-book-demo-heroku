package com.jhart.util.word;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Evaluator {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private SortedMap<String, Integer> wordMapper; 
	
	public Evaluator() {
		setup();
	}
	
	private void evaluate(String word) {
		System.out.println("evaluate - word: " + word);
		if (validate(word)) {
			process(word);
		}
		else {
			System.out.println("failed to validate word: " + word);
		}
	}
	
	public void evaluate(String[] wordArray) {
		System.out.println("evaluate - wordArray size: " + wordArray.length);
		for (String word : wordArray) {
			evaluate(word);
		}
	}
	
	public Map<String, Integer> getWordAnalysis(){
		return wordMapper;
	}
	
	private void process(String word) {
		processKey1(word);
		processKey2(word);
		processKey3(word);
		processKey4(word);
		processKey5(word);
		System.out.println("process complete");
	}
	
	private void processKey1(String word) {
		System.out.println("process Key1 word: " + word);
		Character ch  = word.charAt(0);
		String s = ch.toString();
		String keyContent = "1-"+s;
		
		Integer content1 = wordMapper.get(keyContent);
		if (content1 == null) {
			wordMapper.put(keyContent, 1);
		}
		else {
			Integer a = wordMapper.get(keyContent);
			Integer update = a + 1;
			wordMapper.put(keyContent, update);
			
		}
	}
	
	private void processKey2(String word) {
		System.out.println("process Key2 word: " + word);
		Character ch  = word.charAt(1);
		String s = ch.toString();
		String keyContent = "2-"+s;
		
		Integer content2 = wordMapper.get(keyContent);
		if (content2 == null) {
			wordMapper.put(keyContent, 1);
		}
		else {
			Integer b = wordMapper.get(keyContent);
			Integer update = b + 1;
			wordMapper.put(keyContent, update);
		}
	}
	
	private void processKey3(String word) {
		System.out.println("process Key3 word: " + word);
		Character ch  = word.charAt(2);
		String s = ch.toString();
		String keyContent = "3-"+s;
		
		Integer content3 = wordMapper.get(keyContent);
		if (content3 == null) {
			wordMapper.put(keyContent, 1);
		}
		else {
			Integer c = wordMapper.get(keyContent);
			Integer update = c + 1;
			wordMapper.put(keyContent, update);
		}
	}
	
	private void processKey4(String word) {
		System.out.println("process Key4 word: " + word);
		Character ch  = word.charAt(3);
		String s = ch.toString();
		String keyContent = "4-"+s;
		
		Integer content4 = wordMapper.get(keyContent);
		if (content4 == null) {
			wordMapper.put(keyContent, 1);
		}
		else {
			Integer d = wordMapper.get(keyContent);
			Integer update = d + 1;
			wordMapper.put(keyContent, update);
		}
	}

	private void processKey5(String word) {
		System.out.println("process Key5 word: " + word);
		Character ch  = word.charAt(4);
		String s = ch.toString();
		String keyContent = "5-"+s;
		
		Integer content5 = wordMapper.get(keyContent);
		if (content5 == null) {
			wordMapper.put(keyContent, 1);
		}
		else {
			Integer e = wordMapper.get(keyContent);
			Integer update = e + 1;
			wordMapper.put(keyContent, update);
		}
	}
	
	private void setup() {
		wordMapper = new TreeMap<>();
	}
	
	private boolean validate(String word) {
		if (null == word) {
			log.info("invalid word (null): " + word);
			return false;
		}
		
		if (word.length() != 5) {
			log.info("invalid word (size): " + word);
			return false;
		}
		return true;
	}
	
	
}
