package com.jhart.transform;

import org.springframework.stereotype.Component;

import com.jhart.domain.Threethirteen;
import com.jhart.dto.ThreethirteenDto;

@Component
public class ThreethirteenTransformerImpl implements ThreethirteenTransformer {
	
	public Threethirteen transformDto(ThreethirteenDto threethirteenDto) {
		Threethirteen threethirteen = new Threethirteen();
		threethirteen.setId(threethirteenDto.getId());
		threethirteen.setPlayDate(threethirteenDto.getPlayDate());
		threethirteen.setStartDate(threethirteenDto.getStartDate());
		threethirteen.setFinishDate(threethirteenDto.getEndDate());
		threethirteen.setGameTime(threethirteenDto.getElapsedTime());
		
		threethirteen.setPlayer1(threethirteenDto.getPlayer1());
		threethirteen.setPlayer2(threethirteenDto.getPlayer2());
		threethirteen.setPlayer3(threethirteenDto.getPlayer3());
		threethirteen.setPlayer4(threethirteenDto.getPlayer4());
		threethirteen.setPlayer5(threethirteenDto.getPlayer5());
		threethirteen.setPlayer6(threethirteenDto.getPlayer6());
		threethirteen.setPlayer7(threethirteenDto.getPlayer7());
		
		threethirteen.setScore1(threethirteenDto.getScore1());
		threethirteen.setScore2(threethirteenDto.getScore2());
		threethirteen.setScore3(threethirteenDto.getScore3());
		threethirteen.setScore4(threethirteenDto.getScore4());
		threethirteen.setScore5(threethirteenDto.getScore5());
		threethirteen.setScore6(threethirteenDto.getScore6());
		threethirteen.setScore7(threethirteenDto.getScore7());
		
		threethirteen.setRoundWins1(threethirteenDto.getRv1());
		threethirteen.setRoundWins2(threethirteenDto.getRv2());
		threethirteen.setRoundWins3(threethirteenDto.getRv3());
		threethirteen.setRoundWins4(threethirteenDto.getRv4());
		threethirteen.setRoundWins5(threethirteenDto.getRv5());
		threethirteen.setRoundWins6(threethirteenDto.getRv6());
		threethirteen.setRoundWins7(threethirteenDto.getRv7());
		
		return threethirteen;
	}
	
	public ThreethirteenDto transformEntity(Threethirteen threethirteen) {
		ThreethirteenDto threethirteenDto = new ThreethirteenDto();
		threethirteenDto.setId(threethirteen.getId());
		threethirteenDto.setPlayDate(threethirteen.getPlayDate());
		threethirteenDto.setStartDate(threethirteen.getStartDate());
		threethirteenDto.setEndDate(threethirteen.getFinishDate());
		threethirteenDto.setElapsedTime(threethirteen.getGameTime());
		threethirteenDto.setWinner(threethirteen.getWinner());
		
		threethirteenDto.setPlayer1(threethirteen.getPlayer1());
		threethirteenDto.setPlayer2(threethirteen.getPlayer2());
		threethirteenDto.setPlayer3(threethirteen.getPlayer3());
		threethirteenDto.setPlayer4(threethirteen.getPlayer4());
		threethirteenDto.setPlayer5(threethirteen.getPlayer5());
		threethirteenDto.setPlayer6(threethirteen.getPlayer6());
		threethirteenDto.setPlayer7(threethirteen.getPlayer7());
		
		threethirteenDto.setScore1(threethirteen.getScore1());
		threethirteenDto.setScore2(threethirteen.getScore2());
		threethirteenDto.setScore3(threethirteen.getScore3());
		threethirteenDto.setScore4(threethirteen.getScore4());
		threethirteenDto.setScore5(threethirteen.getScore5());
		threethirteenDto.setScore6(threethirteen.getScore6());
		threethirteenDto.setScore7(threethirteen.getScore7());
		
		threethirteenDto.setRv1(threethirteen.getRoundWins1());
		threethirteenDto.setRv1(threethirteen.getRoundWins1());
		threethirteenDto.setRv1(threethirteen.getRoundWins1());
		threethirteenDto.setRv1(threethirteen.getRoundWins1());
		threethirteenDto.setRv1(threethirteen.getRoundWins1());
		threethirteenDto.setRv1(threethirteen.getRoundWins1());
		threethirteenDto.setRv1(threethirteen.getRoundWins1());
		threethirteenDto.setRv1(threethirteen.getRoundWins1());
		
		
		
		
		
		
		
		
		
		
		
		return threethirteenDto;
	}


}
