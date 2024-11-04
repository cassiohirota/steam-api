package com.steampi.steam_api.repository;


import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.steampi.steam_api.entity.GenreEntity;

@Repository
public interface GenreRepository extends JpaRepository<GenreEntity, Integer> {

	Optional<GenreEntity> findById(Integer id);

	List<GenreEntity> findAllByCode(Integer code);

	GenreEntity findByCode(Integer code);
	
	void deleteById(Integer id);
	
//	@Modifying
//	@Query (
//	    value = "INSERT INTO steamapi.Genero (name) VALUES (:name)",
//	    nativeQuery = true
//	)
//	void saveGender(String name);
}