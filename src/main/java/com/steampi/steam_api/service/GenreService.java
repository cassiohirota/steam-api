package com.steampi.steam_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.steampi.steam_api.entity.GenreEntity;
import com.steampi.steam_api.repository.GenreRepository;

import dto.GenreDTO;
import jakarta.transaction.Transactional;

@Service
public class GenreService {

	@Autowired
	private GenreRepository repository;

	public void postGenre(String name) {
		repository.save(new GenreEntity(name));
	}
	
	public GenreDTO getGenre(int code) {
		 //Optional<GenreEntity> genreEntity = repository.findById(Integer.valueOf(id));
		
		GenreEntity genreEntity = repository.findByCode(code);
		return new GenreDTO(genreEntity.getCode(), genreEntity.getName());
	}
	
	public GenreEntity putGenre(GenreDTO genreDto) {
		 GenreEntity genreEntity = repository.findByCode(genreDto.getCode());
		 genreEntity = dtoToEntity(genreDto, genreEntity);
		 return	repository.save(genreEntity);
	}
	
	public void deleteGenre(Integer code) {
		repository.deleteById(code);
	}
	
	private GenreEntity dtoToEntity(GenreDTO genreDto, GenreEntity genre) {

		genre.setName(genreDto.getName());
		return genre;
	}
}
