package com.steampi.steam_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.steampi.steam_api.entity.GameEntity;
import com.steampi.steam_api.repository.GameRepository;

import dto.GameDTO;

@Service
public class GameService {
	
	@Autowired
	private GameRepository repository;
	
	public GameEntity getGame(String id) {
		return repository.findByCodGame(Integer.valueOf(id));
	}
	
	public GameEntity getGame(GameDTO gameDto) {
		return repository.findByCodGame(gameDto.getId());
	}
	
	public GameEntity postGame(GameDTO gameDto) {
		return repository.save(new GameEntity(Integer.valueOf(gameDto.getCodGame()), gameDto.getName(), gameDto.getDesc(), gameDto.getGenre(), gameDto.getReqMin(), gameDto.getReqRecommend()));
	}
}
