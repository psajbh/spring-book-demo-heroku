package com.jhart.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="player_view")
public class PlayerView implements IEntity, Serializable {
	private static final long serialVersionUID = 8192697569058152670L;
	
	@Id
	@Column(name = "uuid")
	private String suuid;
	
	@Column(name = "player")
	private String playerName;

	public String getSuuid() {
		return suuid;
	}

	public void setId(String suuid) {
		this.suuid = suuid;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	@Override
	public String toString() {
		return "PlayerView [suuid=" + suuid + ", playerName=" + playerName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(suuid, playerName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerView other = (PlayerView) obj;
		return Objects.equals(suuid, other.suuid) && Objects.equals(playerName, other.playerName);
	}
	
	
	
	
	

}
