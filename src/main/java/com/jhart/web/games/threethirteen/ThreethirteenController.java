package com.jhart.web.games.threethirteen;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhart.domain.Threethirteen;
import com.jhart.dto.ThreethirteenDto;
import com.jhart.service.threethirteen.ThreethirteenService;
import com.jhart.transform.ThreethirteenTransformer;
import com.jhart.util.DateComparer;

@Controller
@RequestMapping({"", "/", "/games/threethirteen"})
public class ThreethirteenController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	private Map<String, LocalDateTime> startDates = new HashMap<>();
	private Map<String, String> startStrings = new HashMap<>();
	private Map<String, String> playersMap = new HashMap<>();
	private List<String> activeUsers = new ArrayList<>();

	private ThreethirteenService threethirteenService;
	private ThreethirteenTransformer threethirteenTransformer;

	public ThreethirteenController(ThreethirteenService threethirteenService, 
			ThreethirteenTransformer threethirteenTransformer) {
		this.threethirteenService = threethirteenService;	
		this.threethirteenTransformer = threethirteenTransformer;
	}
	
	@GetMapping("/index")
	public String index(Model model) {
		log.debug("ThreethirteenController - index() start");
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
		
		activeUsers = threethirteenService.getUserNames();
		activeUsers.add(0,"");
		threethirteenDto.setUsers(activeUsers);
		
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
		model.addAttribute("threethirteenDto", threethirteenDto);
		startDates.put(playDate, now);
		startStrings.put(playDate, playStartText);
		model.addAttribute("activeUsers", activeUsers);
		
		log.info("Three13Controller - index complete");
		return "games/threethirteen/index";
	}
	 	
	@PostMapping("/save")
	public String saveNewThreethirteen(Model model, ThreethirteenDto threethirteenDto) {
		log.info("Three13Controller : saveNewThreethirteen - start");
		
		if(StringUtils.isEmpty(threethirteenDto.getDisplayDate())) {
			log.warn("Three12Controller : saveNewThreethirteen - failed to process, no playDate");
			return "redirect:/games/threethirteen/index";
		}
		
		String playDate = threethirteenDto.getDisplayDate().substring(6);
		log.info("Three13Controller - playDate: " + playDate);
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
			log.warn("saveNewThreethirteen - failure processing as threethirteen is null");
		}
		else {
			threethirteenDto  = threethirteenTransformer.transformEntity(threethirteen);
			playersMap.clear();
			log.info("saveNewThreethirteen - success");
			
			String player1 = threethirteenDto.getPlayer1();
			if (isNotNullOrEmpty(player1)) {
				playersMap.put("player1", player1);
			}
		
			String player2 = threethirteenDto.getPlayer2();
			if (isNotNullOrEmpty(player2)) {
				playersMap.put("player2", player2);
			}
			
			String player3 = threethirteenDto.getPlayer3();
			if (isNotNullOrEmpty(player3)) {
				playersMap.put("player3", player3);
			}

			String player4 = threethirteenDto.getPlayer4();
			if (isNotNullOrEmpty(player4)) {
				playersMap.put("player4", player4);
			}
			
			String player5 = threethirteenDto.getPlayer5();
			if (isNotNullOrEmpty(player5)) {
				playersMap.put("player5", player5);
			}
			
			String player6 = threethirteenDto.getPlayer6();
			if (isNotNullOrEmpty(player6)) {
				playersMap.put("player6", player6);
			}
			
			String player7 = threethirteenDto.getPlayer7();
			if (isNotNullOrEmpty(player7)) {
				playersMap.put("player7", player7);
			}
			log.info("saveNewThreethirteen - players successfully created");
			model.addAttribute("threethirteenDto", threethirteenDto);
		}
		
		log.info("Three13Controller : saveNewThreethirteen - complete -> redirecting to games/threethirteen/save");
		return "games/threethirteen/save";
	}
	
	private boolean isNotNullOrEmpty(String string) {
		if (string != null && !string.isEmpty()) {
			return true;
		}
		return false;
	}
	
	
}
	

