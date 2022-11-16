package com.jhart.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Threethirteen")
public class Threethirteen implements IEntity, Serializable {
	private static final long serialVersionUID = -1094433604961461682L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "play_date", nullable = false, columnDefinition = "varchar(10)")
	private String playDate; 
	
	@Column(name = "game_id", nullable = false, columnDefinition = "varchar(5)")
	private String gameId;
	
	@Column(name = "player_1", nullable = true, columnDefinition = "varchar(15)")
	private String player1;
	
	@Column(name = "score_1", nullable = false, columnDefinition = "int(4)")
	private int score1;
	
	@Column(name = "player_2", nullable = true, columnDefinition = "varchar(15)")
	private String player2;
	
	@Column(name = "score_2", nullable = false, columnDefinition = "int(4)")
	private int score2;
	
	@Column(name = "player_3", nullable = true, columnDefinition = "varchar(15)")
	private String player3;
	
	@Column(name = "score_3", nullable = false, columnDefinition = "int(4)")
	private int score3;
	
	@Column(name = "player_4", nullable = true, columnDefinition = "varchar(15)")
	private String player4;
	
	@Column(name = "score_4", nullable = false, columnDefinition = "int(4)")
	private int score4;
	
	@Column(name = "player_5", nullable = true, columnDefinition = "varchar(15)")
	private String player5;
	
	@Column(name = "score_5", nullable = false, columnDefinition = "int(4)")
	private int score5;
	
	@Column(name = "player_6", nullable = true, columnDefinition = "varchar(15)")
	private String player6;
	
	@Column(name = "score_6", nullable = false, columnDefinition = "int(4)")
	private int score6;
	
	@Column(name = "player_7", nullable = true, columnDefinition = "varchar(15)")
	private String player7;
	
	@Column(name = "score_7", nullable = false, columnDefinition = "int(4)")
	private int score7;
	
	@Column(name = "finish_date", nullable = false, columnDefinition = "varchar(100)")
	private String finishDate;
	
	@Column(name = "winner", nullable = false, columnDefinition = "varchar(15)")
	private String winner;
	
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
	public String getGameId() {
		return gameId;
	}
	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	public String getPlayer1() {
		return player1;
	}
	public void setPlayer1(String player1) {
		this.player1 = player1;
	}
	public int getScore1() {
		return score1;
	}
	public void setScore1(int score1) {
		this.score1 = score1;
	}
	public String getPlayer2() {
		return player2;
	}
	public void setPlayer2(String player2) {
		this.player2 = player2;
	}
	public int getScore2() {
		return score2;
	}
	public void setScore2(int score2) {
		this.score2 = score2;
	}
	public String getPlayer3() {
		return player3;
	}
	public void setPlayer3(String player3) {
		this.player3 = player3;
	}
	public int getScore3() {
		return score3;
	}
	public void setScore3(int score3) {
		this.score3 = score3;
	}
	public String getPlayer4() {
		return player4;
	}
	public void setPlayer4(String player4) {
		this.player4 = player4;
	}
	public int getScore4() {
		return score4;
	}
	public void setScore4(int score4) {
		this.score4 = score4;
	}
	public String getPlayer5() {
		return player5;
	}
	public void setPlayer5(String player5) {
		this.player5 = player5;
	}
	public int getScore5() {
		return score5;
	}
	public void setScore5(int score5) {
		this.score5 = score5;
	}
	public String getPlayer6() {
		return player6;
	}
	public void setPlayer6(String player6) {
		this.player6 = player6;
	}
	public int getScore6() {
		return score6;
	}
	public void setScore6(int score6) {
		this.score6 = score6;
	}
	public String getPlayer7() {
		return player7;
	}
	public void setPlayer7(String player7) {
		this.player7 = player7;
	}
	public int getScore7() {
		return score7;
	}
	public void setScore7(int score7) {
		this.score7 = score7;
	}
	
	public String getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}
	
	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	@Override
	public int hashCode() {
		return Objects.hash(playDate, gameId, id, player1, player2, player3, player4, player5, player6, player7,
				score1, score2, score3, score4, score5, score6, score7);
	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Threethirteen other = (Threethirteen) obj;
//		return Objects.equals(currentDate, other.currentDate) && Objects.equals(gameId, other.gameId)
//				&& Objects.equals(id, other.id) && Objects.equals(player1, other.player1)
//				&& Objects.equals(player2, other.player2) && Objects.equals(player3, other.player3)
//				&& Objects.equals(player4, other.player4) && Objects.equals(player5, other.player5)
//				&& Objects.equals(player6, other.player6) && Objects.equals(player7, other.player7)
//				&& score1 == other.score1 && score2 == other.score2 && score3 == other.score3 && score4 == other.score4
//				&& score5 == other.score5 && score6 == other.score6 && score7 == other.score7;
//	}
	@Override
	public String toString() {
		return "Threethirteen [id=" + id + ", playDate=" + playDate + ", gameId=" + gameId + ", player1="
				+ player1 + ", score1=" + score1 + ", player2=" + player2 + ", score2=" + score2 + ", player3="
				+ player3 + ", score3=" + score3 + ", player4=" + player4 + ", score4=" + score4 + ", player5="
				+ player5 + ", score5=" + score5 + ", player6=" + player6 + ", score6=" + score6 + ", player7="
				+ player7 + ", score7=" + score7 + "]";
	}
	
}
