package com.jhart.service.threethirteen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jhart.domain.Threethirteen;
import com.jhart.dto.ThreethirteenDto;
import com.jhart.exception.threethirteen.ThreethirteenSaveGameException;
import com.jhart.repo.threethirteen.ThreethirteenRepository;

@Service
public class ThreethirteenServiceImpl implements ThreethirteenService {
	Logger log = LoggerFactory.getLogger(this.getClass());
	private final ThreethirteenRepository threethirteenRepository;
	
	public ThreethirteenServiceImpl(ThreethirteenRepository threethirteenRepository) {
		this.threethirteenRepository = threethirteenRepository;
		
	}
	
	@Override
	public Threethirteen process(ThreethirteenDto threethirteenDto) {
		String logReport = new String();
		Threethirteen threethirteen = setupDate(threethirteenDto);
		String winningPlayer = null;
		int winningScore = 300;
		
		if (null == threethirteen) {
			log.error("ThreethirteenService - process date failure");
			return null;
		}
		
		if (null != threethirteenDto.getPlayer1() && threethirteenDto.getPlayer1().length() > 0) {
			threethirteen.setPlayer1(threethirteenDto.getPlayer1());
			threethirteen.setScore1(threethirteenDto.getScore1());
			threethirteen.setRoundWins1(threethirteenDto.getRv1());
			if (threethirteenDto.getScore1() < winningScore) {
				winningPlayer = threethirteenDto.getPlayer1();
				winningScore = threethirteenDto.getScore1();
			}
		}
		
		if (null != threethirteenDto.getPlayer2() && threethirteenDto.getPlayer2().length() > 0) {
			threethirteen.setPlayer2(threethirteenDto.getPlayer2());
			threethirteen.setScore2(threethirteenDto.getScore2());
			threethirteen.setRoundWins2(threethirteenDto.getRv2());
			if (threethirteenDto.getScore2() < winningScore) {
				winningPlayer = threethirteenDto.getPlayer2();
				winningScore = threethirteenDto.getScore2();
			}
			else if (threethirteenDto.getScore2() == winningScore) {
				winningPlayer = winningPlayer + ", " + threethirteenDto.getPlayer2();
			}
		}
		
		if (null != threethirteenDto.getPlayer3() && threethirteenDto.getPlayer3().length() > 0) {
			threethirteen.setPlayer3(threethirteenDto.getPlayer3());
			threethirteen.setScore3(threethirteenDto.getScore3());
			threethirteen.setRoundWins3(threethirteenDto.getRv3());
			if (threethirteenDto.getScore3() < winningScore) {
				winningPlayer = threethirteenDto.getPlayer3();
				winningScore = threethirteenDto.getScore3();
			}
			else if (threethirteenDto.getScore3() == winningScore) {
				winningPlayer = winningPlayer + ", " + threethirteenDto.getPlayer3();
			}
		}
		
		if (null != threethirteenDto.getPlayer4() && threethirteenDto.getPlayer4().length() > 0) {
			threethirteen.setPlayer4(threethirteenDto.getPlayer4());
			threethirteen.setScore4(threethirteenDto.getScore4());
			threethirteen.setRoundWins4(threethirteenDto.getRv4());
			if (threethirteenDto.getScore4() < winningScore) {
				winningPlayer = threethirteenDto.getPlayer4();
				winningScore = threethirteenDto.getScore4();
			}
			else if (threethirteenDto.getScore4() == winningScore) {
				winningPlayer = winningPlayer + ", " + threethirteenDto.getPlayer4();
			}
		}
		
		if (null != threethirteenDto.getPlayer5() && threethirteenDto.getPlayer5().length() > 0) {
			threethirteen.setPlayer5(threethirteenDto.getPlayer5());
			threethirteen.setScore5(threethirteenDto.getScore5());
			threethirteen.setRoundWins5(threethirteenDto.getRv5());
			if (threethirteenDto.getScore5() < winningScore) {
				winningPlayer = threethirteenDto.getPlayer5();
				winningScore = threethirteenDto.getScore5();
			}
			else if (threethirteenDto.getScore5() == winningScore) {
				winningPlayer = winningPlayer + ", " + threethirteenDto.getPlayer5();
			}
		}
		
		if (null != threethirteenDto.getPlayer6() && threethirteenDto.getPlayer6().length() > 0) {
			threethirteen.setPlayer6(threethirteenDto.getPlayer6());
			threethirteen.setScore6(threethirteenDto.getScore6());
			threethirteen.setRoundWins6(threethirteenDto.getRv6());
			if (threethirteenDto.getScore6() < winningScore) {
				winningPlayer = threethirteenDto.getPlayer6();
				winningScore = threethirteenDto.getScore6();
			}
			else if (threethirteenDto.getScore6() == winningScore) {
				winningPlayer = winningPlayer + ", " + threethirteenDto.getPlayer6();
			}
		}
		
		if (null != threethirteenDto.getPlayer7() && threethirteenDto.getPlayer7().length() > 0) {
			threethirteen.setPlayer7(threethirteenDto.getPlayer7());
			threethirteen.setScore7(threethirteenDto.getScore7());
			threethirteen.setRoundWins7(threethirteenDto.getRv7());
			if (threethirteenDto.getScore7() < winningScore) {
				winningPlayer = threethirteenDto.getPlayer7();
				winningScore = threethirteenDto.getScore7();
			}
			else if (threethirteenDto.getScore7() == winningScore) {
				winningPlayer = winningPlayer + ", " + threethirteenDto.getPlayer7();
			}
		}
		
		threethirteen.setWinner(winningPlayer);
		threethirteen.setStartDate(threethirteenDto.getStartDate());
		threethirteen.setFinishDate(threethirteenDto.getEndDate());
		threethirteen.setGameTime(threethirteenDto.getElapsedTime());
		Threethirteen saved;
		
		log.info("ThreethirteenService - save attempt on: " + threethirteen.toString());
		try {
			saved = threethirteenRepository.save(threethirteen);
			log.info("ThreethirteenService - save: " + saved);
			return saved;
		}
		catch(ThreethirteenSaveGameException threethirteenGameException) {
			log.error(threethirteenGameException.getMessage());
		}
		catch(Exception e) {
			log.error(e.getMessage());
		}
		
		return null;
	}
	
	private Threethirteen setupDate(ThreethirteenDto threethirteenDto) {
		Threethirteen threethirteen = new Threethirteen();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		String strDate = threethirteenDto.getDisplayDate().substring(6);
		
		try {
			Date date = formatter.parse(strDate);
			if (null != date) {
				threethirteen.setPlayDate(strDate);
						
			}
			else {
				//need to throw an exception here.
				log.warn("** big issue: threethirteen playDate is null");
			}
		}
		catch(ParseException pe) {
			
			log.warn("failure processing date - " + pe.getMessage());
			return null;
		}
		
		return threethirteen;
	}

}
