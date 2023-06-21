package com.jhart.web.games.spinners;

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

import com.jhart.domain.Spinners;
import com.jhart.dto.SpinnersDto;
import com.jhart.service.spinners.SpinnersService;
import com.jhart.transform.SpinnersTransformer;
import com.jhart.util.DateComparer;

@Controller
@RequestMapping({"", "/", "/games/spinners"})
public class SpinnersController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	private Map<String, LocalDateTime> startDates = new HashMap<>();
	private Map<String, String> startStrings = new HashMap<>();
	private Map<String, String> playersMap = new HashMap<>();
	private List<String> activeUsers = new ArrayList<>();
	
	private SpinnersService spinnersService;
	private SpinnersTransformer spinnersTransformer;
	
	public SpinnersController(SpinnersService spinnersService, 
			SpinnersTransformer spinnersTransformer) {
		this.spinnersService = spinnersService;	
		this.spinnersTransformer = spinnersTransformer;
	}
	
	@GetMapping("/index")
	public String index(Model model) {
		SpinnersDto spinnersDto = new SpinnersDto();
		LocalDateTime now = LocalDateTime.now();
		String dateInfo = dtf.format(now);
		String date = dateInfo.substring(0,10);
		String hrMin = dateInfo.substring(11,19);
		String playStartText = date + " " + hrMin;
		String playDate = date + " " + hrMin.replace(':', '.');
		String displayDate = "Date: " + playDate;
		spinnersDto.setPlayDate(playDate);
		spinnersDto.setDisplayDate(displayDate);
		activeUsers = spinnersService.getUserNames();
		activeUsers.add(0,"");
		spinnersDto.setUsers(activeUsers);
		
		if(playersMap.size() > 0) {
			spinnersDto.setPlayer1(playersMap.get("player1"));
			spinnersDto.setPlayer2(playersMap.get("player2"));
			spinnersDto.setPlayer3(playersMap.get("player3"));
			spinnersDto.setPlayer4(playersMap.get("player4"));
			spinnersDto.setPlayer5(playersMap.get("player5"));
			spinnersDto.setPlayer6(playersMap.get("player6"));
			spinnersDto.setPlayer7(playersMap.get("player7"));
			playersMap.clear();
		}
		
		model.addAttribute("spinnersDto", spinnersDto);
		startDates.put(playDate, now);
		startStrings.put(playDate, playStartText);
		model.addAttribute("activeUsers", activeUsers);
		
		log.info("SpinnersController - index complete");
		return "games/spinners/index";
	}
	 	
	@PostMapping("/save")
	public String saveSpinners(Model model, SpinnersDto spinnersDto) {
		log.info("SpinnersController : saveSpinners - start");
		
		if(!validate(spinnersDto)) {
			log.warn("SpinnersController : saveNewSpinners - players validation failure");
			return "redirect:/spinners/index";
		}
		
		if(StringUtils.isEmpty(spinnersDto.getDisplayDate())) {
			log.warn("SpinnersController : saveSpinners - failed to process, no playDate");
			return "redirect:/spinners/index";
		}
		String playDate = spinnersDto.getDisplayDate().substring(6);
		LocalDateTime startDate = startDates.get(playDate);
		spinnersDto.setStartDate(startDate);
		String startDateStr = startStrings.get(playDate);
		
		LocalDateTime endDate = LocalDateTime.now();
		spinnersDto.setEndDate(endDate);
		
		String dateInfo = dtf.format(endDate);
		String date = dateInfo.substring(0,10);
		String hrMin = dateInfo.substring(11,19);
		String endDateStr = date + " " + hrMin;
		
		DateComparer dateComparer = new DateComparer();
		String elapsedTime = dateComparer.getElapsedTime(startDateStr, endDateStr);
		spinnersDto.setElapsedTime(elapsedTime);
		log.debug("elapsed time: " + elapsedTime);
		Spinners spinners = spinnersService.process(spinnersDto);
		
		if (null == spinners) {
			log.warn("saveNewSpinners - failure processing spinners data");
		}
		else {
			spinnersDto  = spinnersTransformer.transformEntity(spinners);
			playersMap.clear();
			log.info("saveNewsSpinners - success");
			String player1 = spinnersDto.getPlayer1();
			if (isNotNullOrEmpty(player1)) {
				playersMap.put("player1", player1);
			}
		
			String player2 = spinnersDto.getPlayer2();
			if (isNotNullOrEmpty(player2)) {
				playersMap.put("player2", player2);
			}
			
			String player3 = spinnersDto.getPlayer3();
			if (isNotNullOrEmpty(player3)) {
				playersMap.put("player3", player3);
			}

			String player4 = spinnersDto.getPlayer4();
			if (isNotNullOrEmpty(player4)) {
				playersMap.put("player4", player4);
			}
			
			String player5 = spinnersDto.getPlayer5();
			if (isNotNullOrEmpty(player5)) {
				playersMap.put("player5", player5);
			}
			
			String player6 = spinnersDto.getPlayer6();
			if (isNotNullOrEmpty(player6)) {
				playersMap.put("player6", player6);
			}
			
			String player7 = spinnersDto.getPlayer7();
			if (isNotNullOrEmpty(player7)) {
				playersMap.put("player7", player7);
			}
			
			model.addAttribute("spinnersDto", spinnersDto);
		}
		
		return "games/spinners/save";
	}
	
	private boolean validate(SpinnersDto spinnersDto) {
		Map<String, String> uniquePlayerNames = new HashMap<>(); 
		String player1 = spinnersDto.getPlayer1();
		if(isNotNullOrEmpty(player1)) {
			uniquePlayerNames.put(player1, player1);
		}
		else {
			log.info("SpinnersController : saveNewSpinners - Player1 is invalid");
			return false;
		}
		
		String player2 = spinnersDto.getPlayer2();
		if(isNotNullOrEmpty(player2)) {
			if (null == uniquePlayerNames.get(player2)) {
				uniquePlayerNames.put(player2, player2);
			}
			else {
				log.info("SpinnersController : saveNewSpinners - Player2 is invalid");
				return false;
			}
		}
		
		String player3 = spinnersDto.getPlayer3();
		if(isNotNullOrEmpty(player3)) {
			if(isNotNullOrEmpty(player2)) {
				if (null == uniquePlayerNames.get(player3)) {
					uniquePlayerNames.put(player3, player3);
				}
			}
			else {
				log.info("SpinnersController : saveNewSpinners - Player3 is invalid");
				return false;
			}
		}
				
		String player4 = spinnersDto.getPlayer4();
		if(isNotNullOrEmpty(player4)) {
			if(isNotNullOrEmpty(player3)) {
				if (null == uniquePlayerNames.get(player4)) {
					uniquePlayerNames.put(player4, player4);
				}
			}
			else {
				log.info("SpinnersController : saveNewSpinners - Player4 is invalid");
				return false;
			}
		}
		
		String player5 = spinnersDto.getPlayer5();
		if(isNotNullOrEmpty(player5)) {
			if(isNotNullOrEmpty(player4)) {
				if (null == uniquePlayerNames.get(player5)) {
					uniquePlayerNames.put(player5, player5);
				}
			}
			else {
				log.info("SpinnersController : saveNewSpinners - Player5 is invalid");
				return false;
			}
		}

		String player6 = spinnersDto.getPlayer6();
		if(isNotNullOrEmpty(player6)) {
			if(isNotNullOrEmpty(player5)) {
				if (null == uniquePlayerNames.get(player6)) {
					uniquePlayerNames.put(player6, player6);
				}
			}
			else {
				log.info("SpinnersController : saveNewSpinners - Player6 is invalid");
				return false;
			}
		}

		String player7 = spinnersDto.getPlayer7();
		if(isNotNullOrEmpty(player7)) {
			if (isNotNullOrEmpty(player6)) {
				if (null == uniquePlayerNames.get(player7)) {
					uniquePlayerNames.put(player7, player7);
				}
			}
			else {
				log.info("SpinnersController : saveNewSpinners - Player7 is invalid");
				return false;
			}
		}
		
		return true;
		
	}
	
	private boolean isNotNullOrEmpty(String string) {
		if (string != null && !string.isEmpty()) {
			return true;
		}
		return false;
	}

}
