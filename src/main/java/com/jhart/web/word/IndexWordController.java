package com.jhart.web.word;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jhart.domain.Word;
import com.jhart.dto.WordSupportDto;


@Controller
public class IndexWordController {
	Logger log = LoggerFactory.getLogger(IndexWordController.class);
	
	@GetMapping({"/word/index"})
	public String index(Model model) {
		WordSupportDto wordSupportDto = new WordSupportDto();
		model.addAttribute("wordSupportDto", wordSupportDto);
		log.info("IndexWordController - index");
		return "word/index";
	}

	
}
