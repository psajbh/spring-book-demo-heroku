package com.jhart.repo.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jhart.domain.PlayerView;

@Repository("playerRepository")
public interface PlayerRepository extends JpaRepository<PlayerView, String>{
	
	@Query(value = "SELECT player FROM player_view", nativeQuery = true) 
	List<String> findDistinctUserNames();

}
