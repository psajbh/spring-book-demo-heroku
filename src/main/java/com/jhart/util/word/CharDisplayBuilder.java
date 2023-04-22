package com.jhart.util.word;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jhart.dto.CharDisplayDto;

public interface CharDisplayBuilder {
	//List<CharDisplayDto> buildCharDisplayDto1(Map<Integer, ArrayList<CharDisplay>> charDisplayAnalysis);
	
	String buildCharDisplay1(Map<Integer, ArrayList<CharDisplay>> charDisplayAnalysis);
	String buildCharDisplay2(Map<Integer, ArrayList<CharDisplay>> charDisplayAnalysis);
	String buildCharDisplay3(Map<Integer, ArrayList<CharDisplay>> charDisplayAnalysis);
	String buildCharDisplay4(Map<Integer, ArrayList<CharDisplay>> charDisplayAnalysis);
	String buildCharDisplay5(Map<Integer, ArrayList<CharDisplay>> charDisplayAnalysis);
}
