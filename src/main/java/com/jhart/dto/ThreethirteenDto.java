package com.jhart.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class ThreethirteenDto {
	
	private Integer id;
	private String displayDate;
	private String playDate;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private String elapsedTime;
	private String winner;
	private String player1;
	private String player2;
	private String player3;
	private String player4;
	private String player5;
	private String player6;
	private String player7;
	private Integer score1;
	private Integer score2;
	private Integer score3;
	private Integer score4;
	private Integer score5;
	private Integer score6;
	private Integer score7;
	private Integer rv1;
	private Integer rv2;
	private Integer rv3;
	private Integer rv4;
	private Integer rv5;
	private Integer rv6;
	private Integer rv7;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlayDate() {
		return playDate;
	}

	public void setPlayDate(String playDate) {
		this.playDate = playDate;
	}
	
	public String getWinner() {
		return winner;
	}
	
	public void setWinner(String winner) {
		this.winner = winner;
	}
	
	public String getPlayer1() {
		return player1;
	}
	
	public void setPlayer1(String player1) {
		this.player1 = player1;
	}
	
	public String getPlayer2() {
		return player2;
	}
	
	public void setPlayer2(String player2) {
		this.player2 = player2;
	}
	
	public String getPlayer3() {
		return player3;
	}
	
	public void setPlayer3(String player3) {
		this.player3 = player3;
	}
	
	public String getPlayer4() {
		return player4;
	}
	
	public void setPlayer4(String player4) {
		this.player4 = player4;
	}
	
	public String getPlayer5() {
		return player5;
	}
	
	public void setPlayer5(String player5) {
		this.player5 = player5;
	}
	
	public String getPlayer6() {
		return player6;
	}
	
	public void setPlayer6(String player6) {
		this.player6 = player6;
	}
	
	public String getPlayer7() {
		return player7;
	}
	
	public void setPlayer7(String player7) {
		this.player7 = player7;
	}
	
	public Integer getScore1() {
		return score1;
	}
	
	public void setScore1(Integer score1) {
		this.score1 = score1;
	}
	
	public Integer getScore2() {
		return score2;
	}
	
	public void setScore2(Integer score2) {
		this.score2 = score2;
	}
	
	public Integer getScore3() {
		return score3;
	}
	
	public void setScore3(Integer score3) {
		this.score3 = score3;
	}
	
	public Integer getScore4() {
		return score4;
	}
	
	public void setScore4(Integer score4) {
		this.score4 = score4;
	}
	
	public Integer getScore5() {
		return score5;
	}
	
	public void setScore5(Integer score5) {
		this.score5 = score5;
	}
	
	public Integer getScore6() {
		return score6;
	}
	
	public void setScore6(Integer score6) {
		this.score6 = score6;
	}
	
	public Integer getScore7() {
		return score7;
	}
	
	public void setScore7(Integer score7) {
		this.score7 = score7;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}
	
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	
	public LocalDateTime getEndDate() {
		return endDate;
	}
	
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	
	public String getElapsedTime() {
		return elapsedTime;
	}
	
	public void setElapsedTime(String elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
	
	public Integer getRv1() {
		return rv1;
	}
	
	public void setRv1(Integer rv1) {
		this.rv1 = rv1;
	}
	
	public Integer getRv2() {
		return rv2;
	}
	
	public void setRv2(Integer rv2) {
		this.rv2 = rv2;
	}
	
	public Integer getRv3() {
		return rv3;
	}
	
	public void setRv3(Integer rv3) {
		this.rv3 = rv3;
	}
	
	public Integer getRv4() {
		return rv4;
	}
	
	public void setRv4(Integer rv4) {
		this.rv4 = rv4;
	}
	
	public Integer getRv5() {
		return rv5;
	}
	
	public void setRv5(Integer rv5) {
		this.rv5 = rv5;
	}
	
	public Integer getRv6() {
		return rv6;
	}
	
	public void setRv6(Integer rv6) {
		this.rv6 = rv6;
	}
	
	public Integer getRv7() {
		return rv7;
	}
	
	public void setRv7(Integer rv7) {
		this.rv7 = rv7;
	}

	public String getDisplayDate() {
		return displayDate;
	}
	
	public void setDisplayDate(String displayDate) {
		this.displayDate = displayDate;
	}
	
	
	@Override
	public String toString() {
		return "ThreethirteenDto [playDate=" + playDate + ", player1=" + player1
				+ ", player2=" + player2 + ", player3=" + player3 + ", player4=" + player4 + ", player5=" + player5
				+ ", player6=" + player6 + ", player7=" + player7 + ", score1=" + score1 + ", score2=" + score2
				+ ", score3=" + score3 + ", score4=" + score4 + ", score5=" + score5 + ", score6=" + score6
				+ ", score7=" + score7 + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(playDate, player1, player2, player3, player4, player5, player6, player7, score1,
				score2, score3, score4, score5, score6, score7);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ThreethirteenDto other = (ThreethirteenDto) obj;
		return Objects.equals(playDate, other.playDate) 
				&& Objects.equals(player1, other.player1) && Objects.equals(player2, other.player2)
				&& Objects.equals(player3, other.player3) && Objects.equals(player4, other.player4)
				&& Objects.equals(player5, other.player5) && Objects.equals(player6, other.player6)
				&& Objects.equals(player7, other.player7) && score1 == other.score1 && score2 == other.score2
				&& score3 == other.score3 && score4 == other.score4 && score5 == other.score5 && score6 == other.score6
				&& score7 == other.score7;
	}

}
