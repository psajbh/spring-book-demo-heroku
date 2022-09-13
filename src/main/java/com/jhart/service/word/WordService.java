package com.jhart.service.word;

import java.util.List;

import com.jhart.domain.Word;
import com.jhart.dto.WordSupportDto;

public interface WordService {
	List<String> process(WordSupportDto wordSupportDto);
}
