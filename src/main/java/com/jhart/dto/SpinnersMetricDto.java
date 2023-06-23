package com.jhart.dto;

public class SpinnersMetricDto {
	
	private String suuid;
	private String player;
	private int games;
	private int total_score;
	private double average_score;
	private int round_victories;
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
	public int getTotal_score() {
		return total_score;
	}
	public void setTotal_score(int total_score) {
		this.total_score = total_score;
	}
	public double getAverage_score() {
		return average_score;
	}
	public void setAverage_score(double average_score) {
		this.average_score = average_score;
	}
	public int getRound_victories() {
		return round_victories;
	}
	public void setRound_victories(int round_victories) {
		this.round_victories = round_victories;
	}
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	
	

}
