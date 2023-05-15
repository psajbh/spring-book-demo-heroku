package com.jhart.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="threethirteen_metrics")
public class ThreethirteenMetric implements IEntity, Serializable {
	private static final long serialVersionUID = -580453742954045560L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	public String toString() {
		return "ThreethirteenMetrics [suuid=" + suuid + ", player=" + player + ", games=" + games + ", totalScore="
				+ totalScore + ", avgScore=" + avgScore + ", roundWins=" + roundWins + ", wins=" + wins + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(avgScore);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		//result = prime * result + ((games == null) ? 0 : games.hashCode());
		result = prime * result + ((suuid == null) ? 0 : suuid.hashCode());
		result = prime * result + ((player == null) ? 0 : player.hashCode());
		result = prime * result + roundWins;
		result = prime * result + totalScore;
		result = prime * result + wins;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ThreethirteenMetric other = (ThreethirteenMetric) obj;
		if (Double.doubleToLongBits(avgScore) != Double.doubleToLongBits(other.avgScore))
			return false;
//		if (games == null) {
//			if (other.games != null)
//				return false;
//		} else if (!games.equals(other.games))
//			return false;
		if (suuid == null) {
			if (other.suuid != null)
				return false;
		} else if (!suuid.equals(other.suuid))
			return false;
		if (player == null) {
			if (other.player != null)
				return false;
		} else if (!player.equals(other.player))
			return false;
		if (roundWins != other.roundWins)
			return false;
		if (totalScore != other.totalScore)
			return false;
		if (wins != other.wins)
			return false;
		return true;
	}

}
