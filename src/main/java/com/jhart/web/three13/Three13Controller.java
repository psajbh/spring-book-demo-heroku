package com.jhart.web.three13;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jhart.dto.ThreethirteenDto;
import com.jhart.service.threethirteen.ThreethirteenService;

@Controller
public class Three13Controller {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private ThreethirteenService threethirteenService;

	public Three13Controller(ThreethirteenService threethirteenService) {
		this.threethirteenService = threethirteenService;		
	}
	
	@GetMapping("313/index")
	public String index(Model model) {
		ThreethirteenDto threethirteenDto = new ThreethirteenDto();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		String dateInfo = dtf.format(now);
		//System.out.println("now: " + dateInfo);
		//2022/11/15 16:36:33
		String playDate = dateInfo.substring(0,10);
		String hrMin = dateInfo.substring(11,16);
		String gameId = hrMin.replace(':', '.');
		
		threethirteenDto.setPlayDate(playDate);
		threethirteenDto.setGameId(gameId);
		model.addAttribute("threethirteenDto", threethirteenDto);
		log.info("Three13Controller - index");
		return "313/index";
	}
	
	@RequestMapping(value="/313/save", method=RequestMethod.POST)
	public String saveNewThreethirteen(ThreethirteenDto threethirteenDto) {
		log.info("saveNewThreethirteen - start");
		if(StringUtils.isEmpty(threethirteenDto.getPlayDate())) {
			log.warn("saveNewUser - failed to process, no playDate");
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
