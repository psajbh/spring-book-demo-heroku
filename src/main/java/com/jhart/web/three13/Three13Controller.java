package com.jhart.web.three13;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
//import java.util.Date;
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
	//private List<String> playersList= new ArrayList<>();
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
		threethirteenDto.setPlayDate(playDate);
		
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
	
	
//	 @GetMapping("313/replay") public String indexWithPlayers() { 
//		 return null; 
//	 }
	 	
	@PostMapping("313/save")
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
			playersMap.clear();
			log.info("saveNewThreethirteen - success");
			String player1 = threethirteen.getPlayer1();
			if (null != player1) {
				playersMap.put("player1", player1);
			}
		
			String player2 = threethirteen.getPlayer2();
			if (null != player2) {
				playersMap.put("player2", player2);
			}
			
			String player3 = threethirteen.getPlayer3();
			if (null != player3) {
				playersMap.put("player3", player3);
			}

			String player4 = threethirteen.getPlayer4();
			if (null != player4) {
				playersMap.put("player4", player4);
			}
			
			String player5 = threethirteen.getPlayer5();
			if (null != player5) {
				playersMap.put("player5", player5);
			}
			
			String player6 = threethirteen.getPlayer6();
			if (null != player6) {
				playersMap.put("player6", player6);
			}
			
			String player7 = threethirteen.getPlayer7();
			if (null != player7) {
				playersMap.put("player7", player7);
			}
			
			model.addAttribute("threethirteen", threethirteen);
		}
		
		return "313/save";
	}
	
}
