package com.jhart.service.word;

import java.util.Map;

import com.jhart.dto.WordSupportDto;

public interface WordService {
	Map<String, String> process(WordSupportDto wordSupportDto);
}
