package com.steampi.steam_api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.steampi.steam_api.entity.GameEntity;

import dto.GameDTO;
import java.util.List;


@Repository
public interface GameRepository extends JpaRepository<GameEntity, Integer> {

	//@Query("SELECT g FROM game_entity g WHERE cod_game=:codGame")
	GameEntity findByCodGame(Integer codGame);
	
	void deleteByCodGame(Integer codGame);
	
	
	
//	void saveGame(GameDTO game);
}