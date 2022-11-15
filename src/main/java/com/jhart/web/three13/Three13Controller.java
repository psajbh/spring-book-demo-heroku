package com.jhart.web.three13;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jhart.dto.ThreethirteenDto;
import com.jhart.service.threethirteen.ThreethirteenService;

@Controller
public class Three13Controller {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final ThreethirteenService threethirteenService;

	public Three13Controller(ThreethirteenService threethirteenService) {
		this.threethirteenService = threethirteenService;		
	}
	
	@GetMapping("313/index")
	public String index(Model model) {
		ThreethirteenDto threethirteenDto = new ThreethirteenDto();
		model.addAttribute("threethirteenDto", threethirteenDto);
		log.info("Three13Controller - index");
		return "313/index";
	}
	
	@RequestMapping(value="/313/save", method=RequestMethod.POST)
	public String saveNewThreethirteen(ThreethirteenDto threethirteenDto) {
		log.info("saveNewThreethirteen - start");
		if(StringUtils.isEmpty(threethirteenDto.getCurrentDate())) {
			log.warn("saveNewUser - failed to process, no current date");
			return "redirect:/313/index";
		}
		
		boolean result = threethirteenService.process(threethirteenDto);
		
		if (false == result) {
			log.warn("saveNewThreethirteen - failure processing 313 data");
		}
		else {
			log.info("saveNewThreethirteen - success");
		}
		
		
		return "redirect:/313/index";
	}
	
}
