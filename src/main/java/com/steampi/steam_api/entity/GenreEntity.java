package com.steampi.steam_api.entity;

import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@Table
@Builder
@AllArgsConstructor
@ToString
@jakarta.persistence.Entity
public class GenreEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incremento
	@Column(name = "id") // Mapeamento da coluna
	private Integer id;

	private String name;

//	@OneToMany(mappedBy = "genero", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private ArrayList<GameEntity> games; // Um gênero pode ter muitos jogos

	public GenreEntity(String name) {
		this.name = name;
	}
	public GenreEntity() {}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public ArrayList<GameEntity> getGames() {
//		return games;
//	}
//
//	public void setGames(ArrayList<GameEntity> games) {
//		this.games = games;
//	}
//
//	@Override
//	public String toString() {
//		return "Genre [id=" + id + ", name=" + name + ", games=" + games + "]";
//	}

}
