package com.jhart.web.three13;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jhart.domain.Threethirteen;
import com.jhart.dto.ThreethirteenDto;
import com.jhart.service.threethirteen.ThreethirteenService;
import com.jhart.transform.ThreethirteenTransformer;
import com.jhart.util.DateComparer;

@Controller
public class Three13Controller {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	private ThreethirteenService threethirteenService;
	private ThreethirteenTransformer threethirteenTransformer;

	public Three13Controller(ThreethirteenService threethirteenService, 
			ThreethirteenTransformer threethirteenTransformer) {
		this.threethirteenService = threethirteenService;	
		this.threethirteenTransformer = threethirteenTransformer;
	}
	
	private HashMap<String, LocalDateTime> startDates = new HashMap<>();
	private HashMap<String, String> startStrings = new HashMap<>();
	private Map<String, String> playersMap = new HashMap<>();
	
	
	@GetMapping("313/index")
	public String index(Model model) {
		ThreethirteenDto threethirteenDto = new ThreethirteenDto();
		LocalDateTime now = LocalDateTime.now();
		String dateInfo = dtf.format(now);
		String date = dateInfo.substring(0,10);
		String hrMin = dateInfo.substring(11,19);
		String playStartText = date + " " + hrMin;
		String playDate = date + " " + hrMin.replace(':', '.');
		String displayDate = "Date: " + playDate;
		threethirteenDto.setPlayDate(playDate);
		threethirteenDto.setDisplayDate(displayDate);
		
		if(playersMap.size() > 0) {
			threethirteenDto.setPlayer1(playersMap.get("player1"));
			threethirteenDto.setPlayer2(playersMap.get("player2"));
			threethirteenDto.setPlayer3(playersMap.get("player3"));
			threethirteenDto.setPlayer4(playersMap.get("player4"));
			threethirteenDto.setPlayer5(playersMap.get("player5"));
			threethirteenDto.setPlayer6(playersMap.get("player6"));
			threethirteenDto.setPlayer7(playersMap.get("player7"));
			playersMap.clear();
		}
		
		startDates.put(playDate, now);
		startStrings.put(playDate, playStartText);
		
		model.addAttribute("threethirteenDto", threethirteenDto);
		log.info("Three13Controller - index");
		return "313/index";
	}
	 	
	@PostMapping("313/save")
	public String saveNewThreethirteen(Model model, ThreethirteenDto threethirteenDto) {
		log.info("Three12Controller : saveNewThreethirteen - start");
		if(StringUtils.isEmpty(threethirteenDto.getDisplayDate())) {
			log.warn("Three12Controller : saveNewThreethirteen - failed to process, no playDate");
			return "redirect:/313/index";
		}
		String playDate = threethirteenDto.getDisplayDate().substring(6);
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
		log.debug("elapsed time: " + elapsedTime);
		Threethirteen threethirteen = threethirteenService.process(threethirteenDto);
		
		if (null == threethirteen) {
			log.warn("saveNewThreethirteen - failure processing 313 data");
		}
		else {
			threethirteenDto  = threethirteenTransformer.transformEntity(threethirteen);
			playersMap.clear();
			log.info("saveNewThreethirteen - success");
			String player1 = threethirteenDto.getPlayer1();
			if (null != player1) {
				playersMap.put("player1", player1);
			}
		
			String player2 = threethirteenDto.getPlayer2();
			if (null != player2) {
				playersMap.put("player2", player2);
			}
			
			String player3 = threethirteenDto.getPlayer3();
			if (null != player3) {
				playersMap.put("player3", player3);
			}

			String player4 = threethirteenDto.getPlayer4();
			if (null != player4) {
				playersMap.put("player4", player4);
			}
			
			String player5 = threethirteenDto.getPlayer5();
			if (null != player5) {
				playersMap.put("player5", player5);
			}
			
			String player6 = threethirteenDto.getPlayer6();
			if (null != player6) {
				playersMap.put("player6", player6);
			}
			
			String player7 = threethirteenDto.getPlayer7();
			if (null != player7) {
				playersMap.put("player7", player7);
			}
			
			model.addAttribute("threethirteenDto", threethirteenDto);
		}
		
		return "313/save";
	}
	
}
