package com.steampi.steam_api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.steampi.steam_api.entity.GenreEntity;
import com.steampi.steam_api.repository.GenreRepository;

import dto.GenreDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class GenreService {

	@Autowired
	private GenreRepository repository;

	public void postGenre(String name) {
		repository.save(new GenreEntity(name));
	}
	
	public GenreDTO getGenre(int id) {
		 Optional<GenreEntity> genreEntity = repository.findById(Integer.valueOf(id));
		
		return new GenreDTO(genreEntity.get().getCode(), genreEntity.get().getName());
	}
	
	public List<GenreDTO> getAllGenre(int code) {
		List<GenreDTO> listGenreDto = new ArrayList<GenreDTO>();
		List<GenreEntity> listGenreEntity = repository.findAllByCode(code);
		
		listEntitytoDto(listGenreDto, listGenreEntity);
		
		return listGenreDto;
	}
	
	public GenreEntity putGenre(GenreDTO genreDto) {
		Optional<GenreEntity> genreOpt = repository.findById(genreDto.getId());
		GenreEntity genre = genreOpt.get();
		genre = dtoToEntity(genreDto, genre);
		
		return	repository.save(genre);
	}
	
	public void deleteGenre(Integer code) {
		repository.deleteById(code);
	}
	
	private GenreEntity dtoToEntity(GenreDTO genreDto, GenreEntity genre) {

		genre.setCode(genreDto.getCode());
		genre.setName(genreDto.getName());
	    return genre;
	}

	private List<GenreDTO> listEntitytoDto(List<GenreDTO> listGenreDto, List<GenreEntity> listGenreEntity) {

		for(int i= 0; i < listGenreEntity.size(); i++) {

			GenreDTO genre = new GenreDTO();
			genre.setCode(listGenreEntity.get(i).getCode());
			genre.setName(listGenreEntity.get(i).getName());
			listGenreDto.add(genre);
		}
		return listGenreDto;
	}
}
