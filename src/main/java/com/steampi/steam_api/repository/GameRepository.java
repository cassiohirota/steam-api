package com.steampi.steam_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.steampi.steam_api.entity.GameEntity;

import dto.GameDTO;

@Repository
public interface GameRepository extends JpaRepository<GameEntity, Integer> {

	GameEntity findByCodGame(Integer id);
	
//	void saveGame(GameDTO game);
}