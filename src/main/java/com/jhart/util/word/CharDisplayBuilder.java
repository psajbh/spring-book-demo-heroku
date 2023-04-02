package com.jhart.util.word;

import java.util.ArrayList;
import java.util.Map;

public interface CharDisplayBuilder {
	String buildCharDisplay(Map<Integer, ArrayList<CharDisplay>> charDisplayAnalysis);
}
