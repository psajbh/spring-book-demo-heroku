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
//import org.springframework.web.bind.annotation.ResponseBody;

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
	private ThreethirteenService threethirteenService;
	private ThreethirteenTransformer threethirteenTransformer;
	//saveStatus marker1
	//saveStatus is a tool to enable population of selected values for a player
	//this is not working, so marking out the HashMap savStatus and use a List for saveStatus
	//the result is that no players will have an option selected.
	//private HashMap<String, ThreethirteenDto> saveStatus = new HashMap<String, ThreethirteenDto>();
	private List<ThreethirteenDto> saveStatus = new ArrayList<>();
	 

	public ThreethirteenController(ThreethirteenService threethirteenService, 
			ThreethirteenTransformer threethirteenTransformer) {
		this.threethirteenService = threethirteenService;	
		this.threethirteenTransformer = threethirteenTransformer;
	}
	
	private HashMap<String, LocalDateTime> startDates = new HashMap<>();
	private HashMap<String, String> startStrings = new HashMap<>();
	private Map<String, String> playersMap = new HashMap<>();
	private List<String> activeUsers = new ArrayList<>();
	//private Map<String, String> uniquePlayerNames = new HashMap<>();
	
	//@GetMapping("/issue")
	//public String issue(Model model) {
		//return "games/threethirteen/issue"; 
	//}
	
	@GetMapping("/index")
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
		
		//saveStatus marker2
		//int size = saveStatus.size();
		int size = 0;
		if (size == 1) {
			log.info("ThreethirteenController - index: users - saveStatusDto");
			ThreethirteenDto saveStatusDto = saveStatus.get(0);
			activeUsers.clear();
			
			String user1 = playersMap.get("player1");
			if (null != user1) {
				activeUsers.add(user1);
			}
			
			String user2 = playersMap.get("player2");
			if (null != user2) {
				activeUsers.add(user2);
			}
			
			String user3 = playersMap.get("player3");
			if (null != user3) {
				activeUsers.add(user3);
			}
			
			String user4 = playersMap.get("player4");
			if (null != user4) {
				activeUsers.add(user4);
			}
			
			String user5 = playersMap.get("player5");
			if (null != user5) {
				activeUsers.add(user5);
			}
			
			String user6 = playersMap.get("player6");
			if (null != user6) {
				activeUsers.add(user6);
			}
			
			String user7 = playersMap.get("player7");
			if (null != user7) {
				activeUsers.add(user7);
			}
			
			if(playersMap.size() > 0) {
				saveStatusDto.setPlayer1(playersMap.get("player1"));
				saveStatusDto.setPlayer2(playersMap.get("player2"));
				saveStatusDto.setPlayer3(playersMap.get("player3"));
				saveStatusDto.setPlayer4(playersMap.get("player4"));
				saveStatusDto.setPlayer5(playersMap.get("player5"));
				saveStatusDto.setPlayer6(playersMap.get("player6"));
				saveStatusDto.setPlayer7(playersMap.get("player7"));
				playersMap.clear();
			}
			model.addAttribute("threethirteenDto", saveStatusDto);
		}
		else {
			log.info("ThreethirteenController - index: users - activeUsers");
			//saveStatus.clear();
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
		}
		saveStatus.clear();
		startDates.put(playDate, now);
		startStrings.put(playDate, playStartText);
		
		//model.addAttribute("threethirteenDto", threethirteenDto);
		model.addAttribute("activeUsers", activeUsers);
		log.info("Three13Controller - index");
		return "games/threethirteen/index";
	}
	 	
	@PostMapping("/save")
	public String saveNewThreethirteen(Model model, ThreethirteenDto threethirteenDto) {
		log.info("Three13Controller : saveNewThreethirteen - start");
		saveStatus.add(threethirteenDto);
		
		if(!validate(threethirteenDto)) {
			log.warn("Three13Controller : saveNewThreethirteen - players validation failure");
			return "redirect:/games/threethirteen/issue";
		}
		
		if(StringUtils.isEmpty(threethirteenDto.getDisplayDate())) {
			log.warn("Three12Controller : saveNewThreethirteen - failed to process, no playDate");
			return "redirect:/games/threethirteen/index";
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
	
	//validates that the player is not null and with the exception
	//of player1, all previous players are not null as well.
	//there cannot be any empty player values between the first and the last.
	private boolean validate(ThreethirteenDto threethirteenDto) {
		Map<String, String> uniquePlayerNames = new HashMap<>(); 
		String player1 = threethirteenDto.getPlayer1();
		if(isNotNullOrEmpty(player1)) {
			uniquePlayerNames.put("player1", player1);
		}
		else {
			log.info("Three13Controller : saveNewThreethirteen - Player1 is invalid");
			return false;
		}
		
		String player2 = threethirteenDto.getPlayer2();
		if(isNotNullOrEmpty(player2)) {
			if (null == uniquePlayerNames.get(player2)) {
				uniquePlayerNames.put("player2", player2);
			}
			else {
				return false;
			}
		}
		
		String player3 = threethirteenDto.getPlayer3();
		if(isNotNullOrEmpty(player3)) {
			if(isNotNullOrEmpty(player2)) {
				if (null == uniquePlayerNames.get(player3)) {
					uniquePlayerNames.put("player3", player3);
				}
			}
			else {
				log.info("Three13Controller : saveNewThreethirteen - Player2 is invalid");
				return false;
			}
		}
				
		String player4 = threethirteenDto.getPlayer4();
		if(isNotNullOrEmpty(player4)) {
			if(isNotNullOrEmpty(player3)) {
				if (null == uniquePlayerNames.get(player4)) {
					uniquePlayerNames.put("player4", player4);
				}
			}
			else {
				log.info("Three13Controller : saveNewThreethirteen - Player3 is invalid");
				return false;
			}
		}
		
		String player5 = threethirteenDto.getPlayer5();
		if(isNotNullOrEmpty(player5)) {
			if(isNotNullOrEmpty(player4)) {
				if (null == uniquePlayerNames.get(player5)) {
					uniquePlayerNames.put("player5", player5);
				}
			}
			else {
				log.info("Three13Controller : saveNewThreethirteen - Player4 is invalid");
				return false;
			}
		}

		String player6 = threethirteenDto.getPlayer6();
		if(isNotNullOrEmpty(player6)) {
			if(isNotNullOrEmpty(player5)) {
				if (null == uniquePlayerNames.get(player6)) {
					uniquePlayerNames.put("player6", player6);
				}
			}
			else {
				log.info("Three13Controller : saveNewThreethirteen - Player5 is invalid");
				return false;
			}
		}

		String player7 = threethirteenDto.getPlayer7();
		if(isNotNullOrEmpty(player7)) {
			if (isNotNullOrEmpty(player6)) {
				if (null == uniquePlayerNames.get(player7)) {
					uniquePlayerNames.put("player7", player7);
				}
			}
			else {
				log.info("Three13Controller : saveNewThreethirteen - Player6 is invalid");
				return false;
			}
		}
		
		return true;
		
	}
	
	private boolean isNotNullOrEmpty(String string) {
		
		//uniquePlayerNames
		
		
		if (string != null && !string.isEmpty()) {
			return true;
		}
		return false;
	}
	
//	public List<ThreethirteenDto> getSaveStatus() {
//		return saveStatus;
//	}
//
//	public void setSaveStatus(List<ThreethirteenDto> saveStatus) {
//		this.saveStatus = saveStatus;
//	}
	
}
	

