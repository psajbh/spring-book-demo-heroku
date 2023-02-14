package com.jhart.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "spinners")
public class Spinners implements IEntity, Serializable{

	private static final long serialVersionUID = 4761717180850881103L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "play_date", nullable = false, columnDefinition = "varchar(22)")
	private String playDate; 
	
    @Column(name = "start_date", nullable = false, columnDefinition = "DATE")
    private LocalDateTime startDate;
    
    @Column(name = "finish_date", nullable = false, columnDefinition = "DATE")
    private LocalDateTime finishDate;
    
    @Column(name = "winner", nullable = false, columnDefinition = "varchar(15)")
    private String winner;
    
    @Column(name = "game_time", nullable = false, columnDefinition = "varchar(75)")
    private String gameTime;
	
	@Column(name = "player_1", nullable = true, columnDefinition = "varchar(15)")
	private String player1;
	
	@Column(name = "score_1", nullable = true, columnDefinition = "int(4)")
	private Integer score1;
	
	@Column(name = "rv_1", nullable = true, columnDefinition = "int(2)")
	private Integer roundWins1;
		
	@Column(name = "player_2", nullable = true, columnDefinition = "varchar(15)")
	private String player2;
	
	@Column(name = "score_2", nullable = true, columnDefinition = "int(4)")
	private Integer score2;
	
	@Column(name = "rv_2", nullable = true, columnDefinition = "int(2)")
	private Integer roundWins2;

	
	@Column(name = "player_3", nullable = true, columnDefinition = "varchar(15)")
	private String player3;
	
	@Column(name = "score_3", nullable = true, columnDefinition = "int(4)")
	private Integer score3;
	
	@Column(name = "rv_3", nullable = true, columnDefinition = "int(2)")
	private Integer roundWins3;
	
	@Column(name = "player_4", nullable = true, columnDefinition = "varchar(15)")
	private String player4;
	
	@Column(name = "score_4", nullable = true, columnDefinition = "int(4)")
	private Integer score4;
	
	@Column(name = "rv_4", nullable = true, columnDefinition = "int(2)")
	private Integer roundWins4;
	
	@Column(name = "player_5", nullable = true, columnDefinition = "varchar(15)")
	private String player5;
	
	@Column(name = "score_5", nullable = true, columnDefinition = "int(4)")
	private Integer score5;
	
	@Column(name = "rv_5", nullable = true, columnDefinition = "int(2)")
	private Integer roundWins5;
	
	@Column(name = "player_6", nullable = true, columnDefinition = "varchar(15)")
	private String player6;
	
	@Column(name = "score_6", nullable = true, columnDefinition = "int(4)")
	private Integer score6;
	
	@Column(name = "rv_6", nullable = true, columnDefinition = "int(2)")
	private Integer roundWins6;
	
	@Column(name = "player_7", nullable = true, columnDefinition = "varchar(15)")
	private String player7;
	
	@Column(name = "score_7", nullable = true, columnDefinition = "int(4)")
	private Integer score7;
	
	@Column(name = "rv_7", nullable = true, columnDefinition = "int(2)")
	private Integer roundWins7;
	
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
	
    public LocalDateTime getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDateTime finishDate) {
        this.finishDate = finishDate;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
    
    public String getGameTime() {
        return gameTime;
    }

    public void setGameTime(String gameTime) {
        this.gameTime = gameTime;
    }
	
	public String getPlayer1() {
		if (null == player1) {
			setScore1(null);
			setRoundWins1(null);
		}
		return player1;
	}
	
	public void setPlayer1(String player1) {
		this.player1 = player1;
	}
	
	public Integer getScore1() {
		return score1;
	}
	
	public void setScore1(Integer score1) {
		this.score1 = score1;
	}
	
    public Integer getRoundWins1() {
        return roundWins1;
    }

    public void setRoundWins1(Integer roundWins1) {
        this.roundWins1 = roundWins1;
    }
	
	public String getPlayer2() {
		if (null == player2) {
			setScore2(null);
			setRoundWins2(null);
		}
		return player2;
	}
	
	public void setPlayer2(String player2) {
		this.player2 = player2;
	}
	
	public Integer getScore2() {
		return score2;
	}
	
	public void setScore2(Integer score2) {
		this.score2 = score2;
	}
	   
	public Integer getRoundWins2() {
	        return roundWins2;
	}
	
	public void setRoundWins2(Integer roundWins2) {
	    this.roundWins2 = roundWins2;
	}
	
	public String getPlayer3() {
		if (null == player3) {
		     setScore3(null);
		     setRoundWins3(null);
		}
		return player3;
	}
	
	public void setPlayer3(String player3) {
		this.player3 = player3;
	}
	
	public Integer getScore3() {
		return score3;
	}
	
	public void setScore3(Integer score3) {
		this.score3 = score3;
	}
	
    public Integer getRoundWins3() {
        return roundWins3;
    }

    public void setRoundWins3(Integer roundWins3) {
        this.roundWins3 = roundWins3;
    }
	
	public String getPlayer4() {
		if (null == player4) {
		     setScore4(null);
		     setRoundWins4(null);
		}
		return player4;
	}
	
	public void setPlayer4(String player4) {
		this.player4 = player4;
	}
	
	public Integer getScore4() {
		return score4;
	}
	
	public void setScore4(Integer score4) {
		this.score4 = score4;
	}
	
    public Integer getRoundWins4() {
        return roundWins4;
    }

    public void setRoundWins4(Integer roundWins4) {
        this.roundWins4 = roundWins4;
    }
	
	
	public String getPlayer5() {
		if (null == player5) {
		     setScore5(null);
		     setRoundWins5(null);
		}
		return player5;
	}
	
	public void setPlayer5(String player5) {
		this.player5 = player5;
	}
	
	public Integer getScore5() {
		return score5;
	}
	
	public void setScore5(Integer score5) {
		this.score5 = score5;
	}
	
    public Integer getRoundWins5() {
        return roundWins5;
    }

    public void setRoundWins5(Integer roundWins5) {
        this.roundWins5 = roundWins5;
    }
	
	public String getPlayer6() {
		if (null == player6) {
		     setScore6(null);
		     setRoundWins6(null);
		}
		return player6;
	}
	
	public void setPlayer6(String player6) {
		this.player6 = player6;
	}
	
	public Integer getScore6() {
		return score6;
	}
	
	public void setScore6(Integer score6) {
		this.score6 = score6;
	}
	
    public Integer getRoundWins6() {
        return roundWins6;
    }

    public void setRoundWins6(Integer roundWins6) {
        this.roundWins6 = roundWins6;
    }
	
	public String getPlayer7() {
		if (null == player7) {
		     setScore7(null);
		     setRoundWins7(null);
		}
		return player7;
	}
	
	public void setPlayer7(String player7) {
		this.player7 = player7;
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
	
    public Integer getRoundWins7() {
        return roundWins7;
    }

    public void setRoundWins7(Integer roundWins7) {
        this.roundWins7 = roundWins7;
    }

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Threethirteen [id=" + id + ", playDate=" + playDate 
				+ ", player1=" + player1 + ", score1=" + score1 + ", roundWins1=" + roundWins1
				+ ", player2=" + player2 + ", score2=" + score2 + ", roundWins2=" + roundWins2
				+ ", player3=" + player3 + ", score3=" + score3 + ", roundWins3=" + roundWins3
				+ ", player4=" + player4 + ", score4=" + score4 + ", roundWins4=" + roundWins4
				+ ", player5=" + player5 + ", score5=" + score5 + ", roundWins5=" + roundWins5
				+ ", player6=" + player6 + ", score6=" + score6 + ", roundWins6=" + roundWins6
				+ ", player7=" + player7 + ", score7=" + score7 + ", roundWins7=" + roundWins7
				+ ", startDate=" + startDate
				+ ", finishDate=" + finishDate 
				+ ", gameTime=" + gameTime
				+  ", winner=" + winner + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(finishDate, id, playDate, player1, player2, player3, player4, player5, player6, player7,
				score1, score2, score3, score4, score5, score6, score7, winner);
	}
	
}
