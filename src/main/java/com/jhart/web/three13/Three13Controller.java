package com.jhart.web.three13;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jhart.domain.Threethirteen;
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
		String date = dateInfo.substring(0,10);
		String hrMin = dateInfo.substring(11,19);
		String modGameId = hrMin.replace(':', '.');
		String playDate = date + " " + modGameId;
		
		threethirteenDto.setPlayDate(playDate);
		threethirteenDto.setStartDate(now);
		model.addAttribute("threethirteenDto", threethirteenDto);
		log.info("Three13Controller - index");
		return "313/index";
	}
	
	@PostMapping("/313/save")
	public String saveNewThreethirteen(Model model, ThreethirteenDto threethirteenDto) {
		log.info("saveNewThreethirteen - start");
		if(StringUtils.isEmpty(threethirteenDto.getPlayDate())) {
			log.warn("saveNewUser - failed to process, no playDate");
			return "redirect:/313/index";
		}
		
		Threethirteen threethirteen = threethirteenService.process(threethirteenDto);
		
		if (null == threethirteen) {
			log.warn("saveNewThreethirteen - failure processing 313 data");
			// do something
		}
		else {
			log.info("saveNewThreethirteen - success");
			model.addAttribute("threethirteen", threethirteen);
		}
		
		
		return "/313/save";
	}
	
}
