package com.jhart.service.spinners;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jhart.domain.Spinners;
import com.jhart.domain.Threethirteen;
import com.jhart.dto.SpinnersDto;
import com.jhart.dto.ThreethirteenDto;
import com.jhart.exception.threethirteen.ThreethirteenSaveGameException;
import com.jhart.repo.spinners.SpinnersRepository;

@Service
public class SpinnersServiceImpl implements SpinnersService{
	Logger log = LoggerFactory.getLogger(this.getClass());
	private final SpinnersRepository spinnersRepository;
	
	public SpinnersServiceImpl(SpinnersRepository spinnersRepository) {
		this.spinnersRepository = spinnersRepository;
	}
	
	@Override
	public Spinners process(SpinnersDto spinnersDto) {
		String logReport = new String();
		Spinners spinners = setupDate(spinnersDto);
		String winningPlayer = null;
		int winningScore = 300;
		
		if (null == spinners) {
			log.error("SpinnersService - process date failure");
			return null;
		}
		
		if (null != spinnersDto.getPlayer1() && spinnersDto.getPlayer1().length() > 0) {
			spinners.setPlayer1(spinnersDto.getPlayer1());
			spinners.setScore1(spinnersDto.getScore1());
			spinners.setRoundWins1(spinnersDto.getRv1());
			if (spinnersDto.getScore1() < winningScore) {
				winningPlayer = spinnersDto.getPlayer1();
				winningScore = spinnersDto.getScore1();
			}
		}
		
		if (null != spinnersDto.getPlayer2() && spinnersDto.getPlayer2().length() > 0) {
			spinners.setPlayer2(spinnersDto.getPlayer2());
			spinners.setScore2(spinnersDto.getScore2());
			spinners.setRoundWins2(spinnersDto.getRv2());
			if (spinnersDto.getScore2() < winningScore) {
				winningPlayer = spinnersDto.getPlayer2();
				winningScore = spinnersDto.getScore2();
			}
			else if (spinnersDto.getScore2() == winningScore) {
				winningPlayer = winningPlayer + ", " + spinnersDto.getPlayer2();
			}
		}
		
		if (null != spinnersDto.getPlayer3() && spinnersDto.getPlayer3().length() > 0) {
			spinners.setPlayer3(spinnersDto.getPlayer3());
			spinners.setScore3(spinnersDto.getScore3());
			spinners.setRoundWins3(spinnersDto.getRv3());
			if (spinnersDto.getScore3() < winningScore) {
				winningPlayer = spinnersDto.getPlayer3();
				winningScore = spinnersDto.getScore3();
			}
			else if (spinnersDto.getScore3() == winningScore) {
				winningPlayer = winningPlayer + ", " + spinnersDto.getPlayer3();
			}
		}
		
		if (null != spinnersDto.getPlayer4() && spinnersDto.getPlayer4().length() > 0) {
			spinners.setPlayer4(spinnersDto.getPlayer4());
			spinners.setScore4(spinnersDto.getScore4());
			spinners.setRoundWins4(spinnersDto.getRv4());
			if (spinnersDto.getScore4() < winningScore) {
				winningPlayer = spinnersDto.getPlayer4();
				winningScore = spinnersDto.getScore4();
			}
			else if (spinnersDto.getScore4() == winningScore) {
				winningPlayer = winningPlayer + ", " + spinnersDto.getPlayer4();
			}
		}
		
		if (null != spinnersDto.getPlayer5() && spinnersDto.getPlayer5().length() > 0) {
			spinners.setPlayer5(spinnersDto.getPlayer5());
			spinners.setScore5(spinnersDto.getScore5());
			spinners.setRoundWins5(spinnersDto.getRv5());
			if (spinnersDto.getScore5() < winningScore) {
				winningPlayer = spinnersDto.getPlayer5();
				winningScore = spinnersDto.getScore5();
			}
			else if (spinnersDto.getScore5() == winningScore) {
				winningPlayer = winningPlayer + ", " + spinnersDto.getPlayer5();
			}
		}
		
		if (null != spinnersDto.getPlayer6() && spinnersDto.getPlayer6().length() > 0) {
			spinners.setPlayer6(spinnersDto.getPlayer6());
			spinners.setScore6(spinnersDto.getScore6());
			spinners.setRoundWins6(spinnersDto.getRv6());
			if (spinnersDto.getScore6() < winningScore) {
				winningPlayer = spinnersDto.getPlayer6();
				winningScore = spinnersDto.getScore6();
			}
			else if (spinnersDto.getScore6() == winningScore) {
				winningPlayer = winningPlayer + ", " + spinnersDto.getPlayer6();
			}
		}
		
		if (null != spinnersDto.getPlayer7() && spinnersDto.getPlayer7().length() > 0) {
			spinners.setPlayer7(spinnersDto.getPlayer7());
			spinners.setScore7(spinnersDto.getScore7());
			spinners.setRoundWins7(spinnersDto.getRv7());
			if (spinnersDto.getScore7() < winningScore) {
				winningPlayer = spinnersDto.getPlayer7();
				winningScore = spinnersDto.getScore7();
			}
			else if (spinnersDto.getScore7() == winningScore) {
				winningPlayer = winningPlayer + ", " + spinnersDto.getPlayer7();
			}
		}
		
		spinners.setWinner(winningPlayer);
		spinners.setStartDate(spinnersDto.getStartDate());
		spinners.setFinishDate(spinnersDto.getEndDate());
		spinners.setGameTime(spinnersDto.getElapsedTime());
		Spinners saved;
		
		log.info("ThreethirteenService - save attempt on: " + spinners.toString());
		try {
			saved = spinnersRepository.save(spinners);
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
	
	private Spinners setupDate(SpinnersDto spinnersDto) {
		Spinners spinners = new Spinners();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		String strDate = spinnersDto.getDisplayDate().substring(6);
		
		try {
			Date date = formatter.parse(strDate);
			if (null != date) {
				spinners.setPlayDate(strDate);
						
			}
			else {
				//need to throw an exception here.
				log.warn("** big issue: spinners playDate is null");
			}
		}
		catch(ParseException pe) {
			log.warn("failure processing date - " + pe.getMessage());
			return null;
		}
		
		return spinners;
	}

}
