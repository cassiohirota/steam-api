package com.steampi.steam_api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.steampi.steam_api.entity.GenreEntity;
import com.steampi.steam_api.repository.GenreRepository;

import dto.GenreDTO;

@Service
public class GenreService {

	@Autowired
	private GenreRepository repository;

	public void postGenre(String name) {
		repository.save(new GenreEntity(name));
	}
	
	public GenreDTO getGenre(String id) {
		 Optional<GenreEntity> genreEntity = repository.findById(Integer.valueOf(id));
		
		return new GenreDTO(String.valueOf(genreEntity.get().getId()), genreEntity.get().getName());
	}
}
