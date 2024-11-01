package com.steampi.steam_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.steampi.steam_api.entity.GameEntity;
import com.steampi.steam_api.repository.GameRepository;

import dto.GameDTO;
import jakarta.transaction.Transactional;

@Service
public class GameService {

	@Autowired
	private GameRepository repository;

	public GameDTO getGame(Integer id) {
		GameEntity gameEnt = new GameEntity();
		gameEnt = repository.findByCodGame(id);

		return new GameDTO(gameEnt.getCodGame(), gameEnt.getName(), gameEnt.getDescricao(), gameEnt.getReqMin(),
				gameEnt.getReqRecommend());
	}
	/*
	 * public GameEntity getGame(GameDTO gameDto) { GameEntity game =
	 * repository.findByCodGame(gameDto.getId()); return game; }
	 */

	public GameEntity postGame(GameDTO gameDto) {
		return repository.save(new GameEntity(Integer.valueOf(gameDto.getCodGame()), gameDto.getName(),
				gameDto.getDesc(), gameDto.getGenre(), gameDto.getReqMin(), gameDto.getReqRecommend()));
	}

	public GameEntity putGame(GameDTO gameDto) {
		return repository.save(new GameEntity(Integer.valueOf(gameDto.getCodGame()), gameDto.getName(),
				gameDto.getDesc(), gameDto.getGenre(), gameDto.getReqMin(), gameDto.getReqRecommend()));
	}

	@Transactional
	public void deleteGame(Integer code) {
		repository.deleteByCodGame(code);
	}
}
