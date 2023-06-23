package com.jhart.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="spinners_metrics")
public class SpinnersMetric implements IEntity, Serializable {
	private static final long serialVersionUID = -1066430141945397523L;

	@Id
	@Column(name = "uuid")
    private String suuid;

	@Column(name = "player")
	private String player;
	
	@Column(name = "games")
	private int games;
	
	@Column(name = "total_score")
	private int totalScore;
	
	@Column(name = "avg_score")
	private double avgScore;
	
	@Column(name = "rv")
	private int roundWins;
	
	@Column(name = "wins")
	private int wins;

	public String getSuuid() {
		return suuid;
	}

	public void setSuuid(String suuid) {
		this.suuid = suuid;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public int getGames() {
		return games;
	}

	public void setGames(int games) {
		this.games = games;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public double getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(double avgScore) {
		this.avgScore = avgScore;
	}

	public int getRoundWins() {
		return roundWins;
	}

	public void setRoundWins(int roundWins) {
		this.roundWins = roundWins;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	@Override
	public int hashCode() {
		return Objects.hash(avgScore, games, player, roundWins, suuid, totalScore, wins);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpinnersMetric other = (SpinnersMetric) obj;
		return Double.doubleToLongBits(avgScore) == Double.doubleToLongBits(other.avgScore) && games == other.games
				&& Objects.equals(player, other.player) && roundWins == other.roundWins
				&& Objects.equals(suuid, other.suuid) && totalScore == other.totalScore && wins == other.wins;
	}

	@Override
	public String toString() {
		return "SpinnersMetric [suuid=" + suuid + ", player=" + player + ", games=" + games + ", totalScore="
				+ totalScore + ", avgScore=" + avgScore + ", roundWins=" + roundWins + ", wins=" + wins + "]";
	}
	

}
