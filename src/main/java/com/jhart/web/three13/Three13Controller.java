package com.jhart.web.three13;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//import java.util.Date;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PutMapping;

import com.jhart.domain.Threethirteen;
import com.jhart.dto.ThreethirteenDto;
import com.jhart.service.threethirteen.ThreethirteenService;
import com.jhart.util.DateComparer;

@Controller
public class Three13Controller {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	private ThreethirteenService threethirteenService;

	public Three13Controller(ThreethirteenService threethirteenService) {
		this.threethirteenService = threethirteenService;		
	}
	
	private HashMap<String, LocalDateTime> startDates = new HashMap<>();
	private HashMap<String, String> startStrings = new HashMap<>();
	
//	@PutMapping("313/index")
//	public String update(Model model, ThreethirteenDto threethirteenDto) {
//	    return "313/index";
//	}
	
	@GetMapping("313/index")
	public String index(Model model, ThreethirteenDto threethirteenDto) {
	    if (null == threethirteenDto) {
	        threethirteenDto = new ThreethirteenDto();
	    }
	    else {
	        
	    }
		//ThreethirteenDto threethirteenDto = new ThreethirteenDto();
		LocalDateTime now = LocalDateTime.now();
		String dateInfo = dtf.format(now);
		String date = dateInfo.substring(0,10);
		String hrMin = dateInfo.substring(11,19);
		String playStartText = date + " " + hrMin;
		String playDate = date + " " + hrMin.replace(':', '.');
		threethirteenDto.setPlayDate(playDate);
		
		startDates.put(playDate, now);
		startStrings.put(playDate, playStartText);
		
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
		
		String playDate = threethirteenDto.getPlayDate();
		LocalDateTime startDate = startDates.get(playDate);
		threethirteenDto.setStartDate(startDate);
		String startDateStr = startStrings.get(playDate);
		
		LocalDateTime endDate = LocalDateTime.now();
		threethirteenDto.setEndDate(endDate);
		
		String dateInfo = dtf.format(endDate);
		String date = dateInfo.substring(0,10);
		String hrMin = dateInfo.substring(11,19);
		String endDateStr = date + " " + hrMin;
		
		DateComparer dateComparer = new DateComparer();
		String elapsedTime = dateComparer.getElapsedTime(startDateStr, endDateStr);
		threethirteenDto.setElapsedTime(elapsedTime);
		System.out.println("elapsed time: " + elapsedTime);
		Threethirteen threethirteen = threethirteenService.process(threethirteenDto);
		
		if (null == threethirteen) {
			log.warn("saveNewThreethirteen - failure processing 313 data");
		}
		else {
			log.info("saveNewThreethirteen - success");
			model.addAttribute("threethirteen", threethirteen);
		}
		
		return "/313/save";
	}
	
}
