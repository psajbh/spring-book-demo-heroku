package com.jhart.transform;

import org.springframework.stereotype.Component;

import com.jhart.domain.Spinners;
import com.jhart.dto.SpinnersDto;

@Component
public class SpinnersTransformerImpl implements SpinnersTransformer {
	
	@Override
	public Spinners transformDto(SpinnersDto spinnersDto) {
		Spinners spinners = new Spinners();
		spinners.setId(spinnersDto.getId());
		spinners.setPlayDate(spinnersDto.getPlayDate());
		spinners.setStartDate(spinnersDto.getStartDate());
		spinners.setFinishDate(spinnersDto.getEndDate());
		spinners.setGameTime(spinnersDto.getElapsedTime());
		
		spinners.setPlayer1(spinnersDto.getPlayer1());
		spinners.setPlayer2(spinnersDto.getPlayer2());
		spinners.setPlayer3(spinnersDto.getPlayer3());
		spinners.setPlayer4(spinnersDto.getPlayer4());
		spinners.setPlayer5(spinnersDto.getPlayer5());
		spinners.setPlayer6(spinnersDto.getPlayer6());
		spinners.setPlayer7(spinnersDto.getPlayer7());
		
		spinners.setScore1(spinnersDto.getScore1());
		spinners.setScore2(spinnersDto.getScore2());
		spinners.setScore3(spinnersDto.getScore3());
		spinners.setScore4(spinnersDto.getScore4());
		spinners.setScore5(spinnersDto.getScore5());
		spinners.setScore6(spinnersDto.getScore6());
		spinners.setScore7(spinnersDto.getScore7());
		
		spinners.setRoundWins1(spinnersDto.getRv1());
		spinners.setRoundWins2(spinnersDto.getRv2());
		spinners.setRoundWins3(spinnersDto.getRv3());
		spinners.setRoundWins4(spinnersDto.getRv4());
		spinners.setRoundWins5(spinnersDto.getRv5());
		spinners.setRoundWins6(spinnersDto.getRv6());
		spinners.setRoundWins7(spinnersDto.getRv7());
		
		return spinners;
	}
	
	@Override
	public SpinnersDto transformEntity(Spinners spinners) {
		SpinnersDto spinnersDto = new SpinnersDto();
		spinnersDto.setId(spinners.getId());
		spinnersDto.setPlayDate(spinners.getPlayDate());
		spinnersDto.setStartDate(spinners.getStartDate());
		spinnersDto.setEndDate(spinners.getFinishDate());
		spinnersDto.setElapsedTime(spinners.getGameTime());
		spinnersDto.setWinner(spinners.getWinner());
		
		spinnersDto.setPlayer1(spinners.getPlayer1());
		spinnersDto.setPlayer2(spinners.getPlayer2());
		spinnersDto.setPlayer3(spinners.getPlayer3());
		spinnersDto.setPlayer4(spinners.getPlayer4());
		spinnersDto.setPlayer5(spinners.getPlayer5());
		spinnersDto.setPlayer6(spinners.getPlayer6());
		spinnersDto.setPlayer7(spinners.getPlayer7());
		
		spinnersDto.setScore1(spinners.getScore1());
		spinnersDto.setScore2(spinners.getScore2());
		spinnersDto.setScore3(spinners.getScore3());
		spinnersDto.setScore4(spinners.getScore4());
		spinnersDto.setScore5(spinners.getScore5());
		spinnersDto.setScore6(spinners.getScore6());
		spinnersDto.setScore7(spinners.getScore7());
		
		spinnersDto.setRv1(spinners.getRoundWins1());
		spinnersDto.setRv2(spinners.getRoundWins2());
		spinnersDto.setRv3(spinners.getRoundWins3());
		spinnersDto.setRv4(spinners.getRoundWins4());
		spinnersDto.setRv5(spinners.getRoundWins5());
		spinnersDto.setRv6(spinners.getRoundWins6());
		spinnersDto.setRv7(spinners.getRoundWins7());
		
		return spinnersDto;
	}


}
